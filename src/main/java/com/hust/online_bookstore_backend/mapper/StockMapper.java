package com.hust.online_bookstore_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hust.online_bookstore_backend.entity.Stock;
import com.hust.online_bookstore_backend.entity.StockVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface StockMapper extends BaseMapper<Stock> {

    /**
     * 检查特定书籍ID是否存在缺书记录
     * @param bookId 书籍ID
     * @return 如果存在返回true，否则返回false
     */
    @Select("SELECT EXISTS (SELECT 1 FROM stock WHERE bookId = #{bookId})")
    boolean existsStockRecordByBookId(@Param("bookId") Long bookId);

    /**
     * 插入新的缺书记录
     *
     * @param stock 缺书记录对象
     */
    @Insert("INSERT INTO stock (bookId, supplierId, num, date_) VALUES (#{bookId}, #{supplierId}, #{num}, #{date_})")
    void insertStock(Stock stock);

     @Select("""
            SELECT *
            FROM stock sk, book b, supplier sr
            where sk.bookId = b.bookId and sk.supplierId = sr.supplierId
            """)
    List<StockVO> selectALLList(Object o);
}