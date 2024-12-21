package com.hust.online_bookstore_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hust.online_bookstore_backend.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService extends IService<Book>{
     List<Book> searchBooksByKeyword(Page<Book> page, String keyword);
     List<Book> selectBooksByOrderWay(Page<Book> page, int orderWay);
}
