package com.hust.online_bookstore_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("stock")
public class Stock {

    @TableId(value = "stockId")
    private Integer stockId;

    private Long bookId; // 假设bookId是bigint类型，但Java中通常使用Long

    private String supplierId; // 假设supplierId是varchar类型，长度为30

    private Integer num; // 书籍数量

    private LocalDateTime date_; // 登记日期，使用Java 8的LocalDateTime类型

}