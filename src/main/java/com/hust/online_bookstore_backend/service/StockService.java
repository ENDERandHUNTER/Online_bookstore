package com.hust.online_bookstore_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hust.online_bookstore_backend.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService extends IService<Stock> {
   boolean appendStock(Stock stock);

   List<Stock> getStockList();
}