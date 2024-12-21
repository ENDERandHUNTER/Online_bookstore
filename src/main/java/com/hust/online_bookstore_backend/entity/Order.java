package com.hust.online_bookstore_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order")
public class Order {

    @TableId(value = "orderId")
    private Integer orderId;

    private String customerId;

    private Byte state;

    private String orderAddress;
}