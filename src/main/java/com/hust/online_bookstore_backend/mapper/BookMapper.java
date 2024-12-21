package com.hust.online_bookstore_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hust.online_bookstore_backend.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
        @Select("""
            select * from book
            where  book.name LIKE CONCAT('%', #{keyword}, '%')
                   OR book.author LIKE CONCAT('%', #{keyword}, '%')
                   OR book.keyword LIKE CONCAT('%', #{keyword}, '%')
        """)
        List<Book> selectByKeyword(Page<Book> page, @Param("keyword") String keyword);

        @Select("""
            select * from book
            ORDER BY book.price ASC
        """)
        List<Book> selectByPriceUP(Page<Book> page);

        @Select("""
            select * from book
           order by book.price DESC
        """)
        List<Book> selectByPriceDown(Page<Book> page);

        @Select("""
            select * from book
        """)
        List<Book> selectAllBooks(Page<Book> page);

        @Update("""
            UPDATE book
                  SET inventory = inventory - 1
                  WHERE bookId = #{bookId} AND inventory > 0
        """)
        int dsecInventoryById( @Param("bookid")int bookId);
}
