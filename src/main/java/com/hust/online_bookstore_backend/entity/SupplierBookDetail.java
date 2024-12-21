package com.hust.online_bookstore_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("supplierbookdetail")
public class SupplierBookDetail implements Serializable {

    @TableId(value = "bookId")
    private Long bookId;

    private Integer supplierId;

    private Integer ISBN;

    private Integer inventory;
}