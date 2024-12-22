package com.hust.online_bookstore_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hust.online_bookstore_backend.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
