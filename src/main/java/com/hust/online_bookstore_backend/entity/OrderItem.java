package com.hust.online_bookstore_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("orderItem")
public class OrderItem {

    @TableId(value = "orderItemId")
    private Integer orderItemId;

    private Integer orderId;

    private Integer bookId;

    private Integer orderNum;
}
