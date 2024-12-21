package com.hust.online_bookstore_backend.controller;

import com.hust.online_bookstore_backend.entity.JsonResult;
import com.hust.online_bookstore_backend.entity.Stock;
import com.hust.online_bookstore_backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/customer/appendStock")
    public Object appendStock(@RequestBody Stock stock) {
        boolean success = stockService.appendStock(stock);
        if (success) {
            return new JsonResult(true, "缺书登记成功");
        } else {
            return new JsonResult(false, "该书的缺书记录已存在");
        }
    }

    @GetMapping("/business/stockList")
    public JsonResult getPurchaseList(){
        return new JsonResult(stockService.getStockList());
    }
}