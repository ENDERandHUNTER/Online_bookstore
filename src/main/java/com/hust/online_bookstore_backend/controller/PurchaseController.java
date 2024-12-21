package com.hust.online_bookstore_backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hust.online_bookstore_backend.entity.JsonResult;
import com.hust.online_bookstore_backend.entity.Purchase;
import com.hust.online_bookstore_backend.entity.Stock;
import com.hust.online_bookstore_backend.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/purchaseList")
    public JsonResult getPurchaseList(){
        return new JsonResult(purchaseService.getPurchaseList());
    }
    @PostMapping("/appendPurchases")
    public JsonResult producePurchase(@RequestBody List<Stock> stockList) {
        purchaseService.producePurchase(stockList);
        return new JsonResult(true, "采购单生成成功");
    }

    @DeleteMapping("/deleteStock/{purchaseId}")
    public void deleteStock(@PathVariable("purchaseId")Integer purchaseId) {
        purchaseService.deleteStock(purchaseId);
    }
}
