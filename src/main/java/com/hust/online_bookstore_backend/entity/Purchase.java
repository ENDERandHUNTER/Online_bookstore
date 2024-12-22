package com.hust.online_bookstore_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("purchase")
public class Purchase {
    @TableId(value = "purchaseId")
    private Integer purchaseId;

    private Integer stockId;

    private Boolean isFinished;

    private Integer quantity;
}
