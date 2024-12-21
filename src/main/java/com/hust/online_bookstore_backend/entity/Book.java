package com.hust.online_bookstore_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book")
public class Book {

    @TableId(value = "bookId")
    private Long bookId;

    private String isbn;
    private String name;
    private String publish;
    private Float price;
    private Integer inventory;
    private String author;
    private String keyword;
}
