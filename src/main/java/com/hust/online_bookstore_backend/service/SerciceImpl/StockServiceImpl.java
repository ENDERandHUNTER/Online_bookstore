package com.hust.online_bookstore_backend.service.SerciceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hust.online_bookstore_backend.entity.Book;
import com.hust.online_bookstore_backend.entity.Purchase;
import com.hust.online_bookstore_backend.entity.Stock;
import com.hust.online_bookstore_backend.entity.StockVO;
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
        //
        if (baseMapper.existsStockRecordByBookId(stock.getBookId())) {
            LambdaQueryWrapper<Stock> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Stock::getBookId,stock.getBookId());
            //stockList为已经存在对应书号的缺货记录的列表，如果列表的每一项都已经采购完成，那么就代表可以添加该书号的缺货记录
            List<Stock> stockList = stockMapper.selectList(queryWrapper);
            for (Stock stock_judged : stockList) {
                LambdaQueryWrapper<Purchase> Wrapper = new LambdaQueryWrapper<>();
                Wrapper.eq(Purchase::getStockId,stock_judged.getStockId());
                Purchase purchase = purchaseMapper.selectOne(Wrapper);
                if (purchase == null) {
                    return false;
                }
                else {
                    Boolean isFinished = purchase.getIsFinished();
                    if (isFinished) {
                        continue;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        baseMapper.insertStock(stock);
        return true;
    }

    @Override
    public List<StockVO> getStockList() {
        List<StockVO> stockList = stockMapper.selectALLList(null);
        List<StockVO> realStockVOList = new ArrayList<>();
        for (StockVO stock : stockList) {
            LambdaQueryWrapper<Purchase> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Purchase::getStockId,stock.getStockId());
//            Boolean isFished = purchaseMapper.selectOne(queryWrapper).getIsFished();
            Purchase purchase = purchaseMapper.selectOne(queryWrapper);
            if (purchase == null) {
                realStockVOList.add(stock);
            }
            else {
                 Boolean isFinished = purchase.getIsFinished();
                 if (!isFinished) {
                    realStockVOList.add(stock);
                 }
            }
        }
        return realStockVOList;
    }
}
