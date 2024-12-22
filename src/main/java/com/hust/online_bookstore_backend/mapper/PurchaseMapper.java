package com.hust.online_bookstore_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hust.online_bookstore_backend.entity.Purchase;
import com.hust.online_bookstore_backend.entity.vo.PurchaseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PurchaseMapper extends BaseMapper<Purchase> {
    @Select("""
            SELECT *
            FROM stock sk, book b, supplier sr,purchase p
            where sk.bookId = b.bookId and p.stockId = sk.stockId and sk.supplierId = sr.supplierId
            """)
    List<PurchaseVO> getList();
}