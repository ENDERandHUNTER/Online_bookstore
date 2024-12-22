package com.hust.online_bookstore_backend.controller;

import com.hust.online_bookstore_backend.entity.JsonResult;
import com.hust.online_bookstore_backend.entity.Supplier;
import com.hust.online_bookstore_backend.mapper.SupplierMapper;
import com.hust.online_bookstore_backend.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class SupplierController {

    @Autowired
    private SupplierMapper supplierMapper;

    @GetMapping("/business/supplierList")
    public JsonResult getSupplierList() {
        return new JsonResult(supplierMapper.selectList(null));
    }
}
