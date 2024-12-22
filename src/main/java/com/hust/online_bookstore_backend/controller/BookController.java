package com.hust.online_bookstore_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hust.online_bookstore_backend.entity.Book;
import com.hust.online_bookstore_backend.entity.JsonResult;
import com.hust.online_bookstore_backend.mapper.BookMapper;
import com.hust.online_bookstore_backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    //orderWay为0时不排序，为1时按价格升序排序，为2时按价格降序排列
    @GetMapping("/customer/book/order/{orderWay}")
    public JsonResult getBookList(@PathVariable int orderWay,
                                  @RequestParam(value = "pn",defaultValue ="1" ,required = false) Integer pn,
                                  @RequestParam(value = "ps",defaultValue = "2",required = false) Integer ps){
        Page<Book> page = new Page<>(pn,ps);
        if (orderWay == 0) {
            return new JsonResult(bookMapper.selectAllBooks(page)); // 如果没有指定排序方式，返回所有书籍
        } else {
            return new JsonResult(bookService.selectBooksByOrderWay(page,orderWay));
        }
    }

    @GetMapping("/customer/book/{keyword}")
    public JsonResult searchBookByKeyword(@PathVariable("keyword") String keyword,
                                          @RequestParam(value = "pn",defaultValue ="1" ,required = false) Integer pn,
                                          @RequestParam(value = "ps",defaultValue = "2",required = false) Integer ps){
        Page<Book> page = new Page<>(pn,ps);
        List<Book> bookList = bookService.searchBooksByKeyword(page,keyword);
        if (!bookList.isEmpty()) {
           return new JsonResult(bookList);
        }
        else{
            return new JsonResult(false,"搜索内容不能为空");
        }
    }

    @PostMapping("/customer/buyBook/{bookId}")
    public JsonResult buyBook(@PathVariable int bookId) {
        int res = bookMapper.dsecInventoryById(bookId);
        if (res > 0) {
            return new JsonResult(true,"成功购买");
        }
        else {
            return new JsonResult(false,"库存不足");
        }
    }

    @PostMapping("/business/appendBook")
    public JsonResult appendBook(@RequestBody Book book) {
        int res = bookMapper.insert(book);
        if (res > 0) {
            return new JsonResult(true,"成功添加书籍");
        }
        else{
            return new JsonResult(false,"未成功添加书籍");
        }
    }

    @DeleteMapping("/business/deleteBook/{bookId}")
    public JsonResult deleteBook(@PathVariable int bookId) {
        int res = bookMapper.deleteById(bookId);
        if (res > 0) {
            return new JsonResult(true,"删除失败");
        }
        else {
            return new JsonResult(false,"删除成功");
        }
    }

}
