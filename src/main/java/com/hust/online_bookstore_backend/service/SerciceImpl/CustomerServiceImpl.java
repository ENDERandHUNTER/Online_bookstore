package com.hust.online_bookstore_backend.service.SerciceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hust.online_bookstore_backend.entity.Customer;
import com.hust.online_bookstore_backend.mapper.CustomerMapper;
import com.hust.online_bookstore_backend.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
