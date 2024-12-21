package com.hust.online_bookstore_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("supplier")
public class Supplier {

    @TableId(value = "supplierId")
    private Integer supplierId;

    private String supplierName;

    private String address;
}