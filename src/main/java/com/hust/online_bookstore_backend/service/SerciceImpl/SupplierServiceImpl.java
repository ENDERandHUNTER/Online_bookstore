package com.hust.online_bookstore_backend.service.SerciceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hust.online_bookstore_backend.entity.Supplier;
import com.hust.online_bookstore_backend.mapper.SupplierMapper;
import com.hust.online_bookstore_backend.service.SupplierService;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {
}
