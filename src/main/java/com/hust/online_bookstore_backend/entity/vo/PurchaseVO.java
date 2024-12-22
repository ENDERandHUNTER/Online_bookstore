package com.hust.online_bookstore_backend.entity.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PurchaseVO {
    private Integer stockId; // 库存记录ID

    private Long bookId; // 书籍ID

    private String supplierId; // 供应商ID

    private Integer num; // 采购数量

    private LocalDateTime date_; // 登记日期

    private String isbn;

    private String name; // 书籍名称

    private String publish; // 出版社

    private Float price; // 价格

    private String author; // 作者

    private String supplierName;

    private String address;

    private boolean isFinished;

    private Integer quantity;
}
