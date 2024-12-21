package com.hust.online_bookstore_backend.service.SerciceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hust.online_bookstore_backend.entity.Purchase;
import com.hust.online_bookstore_backend.entity.Stock;
import com.hust.online_bookstore_backend.mapper.PurchaseMapper;
import com.hust.online_bookstore_backend.mapper.StockMapper;
import com.hust.online_bookstore_backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public boolean appendStock(Stock stock) {
        if (baseMapper.existsStockRecordByBookId(stock.getBookId())) {
            // 如果已存在缺书记录，可以选择更新或拒绝登记
            return false;
        }
        baseMapper.insertStock(stock);
        return true;
    }

    @Override
    public List<Stock> getStockList() {
        List<Stock> stockList = stockMapper.selectList(null);
        List<Stock> realStockList = new ArrayList<>();
        for (Stock stock : stockList) {
            LambdaQueryWrapper<Purchase> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Purchase::getStockId,stock.getStockId());
            Boolean isFished = purchaseMapper.selectOne(queryWrapper).getIsFished();
            if (!isFished) {
                realStockList.add(stock);
            }
        }
        return realStockList;
    }
}
