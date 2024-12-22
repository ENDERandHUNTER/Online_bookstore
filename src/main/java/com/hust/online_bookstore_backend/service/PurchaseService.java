package com.hust.online_bookstore_backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hust.online_bookstore_backend.entity.Purchase;
import com.hust.online_bookstore_backend.entity.Stock;
import com.hust.online_bookstore_backend.entity.vo.PurchaseVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService extends IService<Purchase> {
    void producePurchase(List<Stock> stockList);
    List<PurchaseVO>getPurchaseList();

    void deleteStock(Integer purchaseId);
}
