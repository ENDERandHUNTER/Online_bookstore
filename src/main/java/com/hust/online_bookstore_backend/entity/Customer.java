package com.hust.online_bookstore_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("customer")
public class Customer {

    @TableId(value = "customerId")
    private String customerId;

    private String password;

    private String userName;

    private String address;

    private Float balance;

    private Integer creditLevel;
}