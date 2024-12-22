package com.hust.online_bookstore_backend.service.SerciceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hust.online_bookstore_backend.entity.Book;
import com.hust.online_bookstore_backend.entity.Purchase;
import com.hust.online_bookstore_backend.entity.Stock;
import com.hust.online_bookstore_backend.entity.vo.PurchaseVO;
import com.hust.online_bookstore_backend.mapper.BookMapper;
import com.hust.online_bookstore_backend.mapper.PurchaseMapper;
import com.hust.online_bookstore_backend.mapper.StockMapper;
import com.hust.online_bookstore_backend.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private StockMapper stockMapper;
    
    @Autowired
    private BookMapper bookMapper;


    @Override
    public void producePurchase(List<Stock> stockList) {
         System.out.println(stockList);
         for (Stock stock : stockList) {
             // 1. 生成采购单
             Purchase purchase = new Purchase();
             purchase.setStockId(stock.getStockId());
             purchase.setQuantity(stock.getNum());
             System.out.println(purchase);
             purchaseMapper.insert(purchase);
         }
    }

    @Override
    public List<PurchaseVO> getPurchaseList() {
        return purchaseMapper.getList();
    }

    @Override
    public void deleteStock(Integer purchaseId) {
        Purchase purchase = purchaseMapper.selectById(purchaseId);
        LambdaUpdateWrapper<Purchase> Wrapper_purchase = new LambdaUpdateWrapper<>();
        Wrapper_purchase.eq(Purchase::getPurchaseId, purchase.getPurchaseId());
        Wrapper_purchase.set(Purchase::getIsFinished, 1);
        purchaseMapper.update(Wrapper_purchase);
        LambdaQueryWrapper<Stock> queryWrapper_stock = new LambdaQueryWrapper<>();
        queryWrapper_stock.eq(Stock::getStockId, purchase.getStockId());
        Stock stock = stockMapper.selectOne(queryWrapper_stock);
        LambdaUpdateWrapper<Book> Wrapper_book = new LambdaUpdateWrapper<>();
        Wrapper_book.eq(Book::getBookId, stock.getBookId());
        Wrapper_book.set(Book::getInventory, bookMapper.selectById(stock.getBookId()).getInventory() + purchase.getQuantity());
        bookMapper.update(Wrapper_book);
        // 4. 发送EMAIL通知（如果需要）
    }
}
