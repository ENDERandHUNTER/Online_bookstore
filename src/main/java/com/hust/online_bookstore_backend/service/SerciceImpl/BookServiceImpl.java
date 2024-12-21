package com.hust.online_bookstore_backend.service.SerciceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hust.online_bookstore_backend.entity.Book;
import com.hust.online_bookstore_backend.mapper.BookMapper;
import com.hust.online_bookstore_backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;


@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    /**
     * 根据关键词模糊匹配查询书籍
     *
     * @param keyword 搜索关键词
     * @return 匹配的书籍列表
     */
    public List<Book> searchBooksByKeyword(Page<Book> page, String keyword) {
        // 检查输入参数是否为空或只包含空格
        if (keyword == null || keyword.trim().isEmpty()) {
            // 如果关键词无效，可以返回空列表或者抛出一个自定义异常
            return Collections.emptyList(); // 返回空列表
            // 或者抛出异常
            // throw new IllegalArgumentException("搜索关键词不能为空");
        }

        // 调用Mapper层的方法进行查询
        return baseMapper.selectByKeyword(page,keyword);
    }

    @Override
    public List<Book> selectBooksByOrderWay(Page<Book> page, int orderWay) {
        if(orderWay == 1){
            return baseMapper.selectByPriceUP(page);
        }
        else{
            return baseMapper.selectByPriceDown(page);
        }
    }
}
