package com.hust.online_bookstore_backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.hust.online_bookstore_backend.entity.Customer;
import com.hust.online_bookstore_backend.entity.JsonResult;
import com.hust.online_bookstore_backend.mapper.CustomerMapper;
import com.hust.online_bookstore_backend.service.CustomerService;
import com.hust.online_bookstore_backend.utils.JwtUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class CustomerController {
     @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping("/customer/reg")
    public JsonResult reg(@RequestBody Customer customer){
        int rs = 0;
        LambdaQueryWrapper<Customer> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Customer::getUserName,customer.getUserName());
        Customer u = customerService.getOne(lambdaQueryWrapper);
        if(u==null){
            rs= customerMapper.insert(customer);
        }
        else{
            return new JsonResult(false,"用户名已存在，请更换用户名");
        }
        if(rs==1){
            System.out.println("注册成功");
            return new JsonResult(true,customer,"注册成功");
        }else{
            return new JsonResult(false,"注册失败");
        }
    }

    @PostMapping("/customer/login")
    public JsonResult login(@RequestBody Customer customer){
        //1
        //2
//        System.out.println(customer);
        LambdaQueryWrapper<Customer> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Customer::getUserName,customer.getUserName())
                .eq(Customer::getPassword,customer.getPassword());
        Customer u= customerService.getOne(lambdaQueryWrapper);
        if(u!=null){
            //生成令牌token字符串
            String token= JwtUtils.sign(u);
            return new JsonResult(true,u,token);
        }else {
            return new JsonResult(false,"用户名或密码错误！");
        }
    }

    @PutMapping("/customer/updateCustomerINFO")
    public JsonResult update(@RequestBody Customer customer){
        int rs = 0;
        LambdaUpdateWrapper<Customer> lambdaQueryWrapper=new LambdaUpdateWrapper<>();
        lambdaQueryWrapper.eq(Customer::getCustomerId,customer.getCustomerId())
                .set(Customer::getUserName,customer.getUserName())
                .set(Customer::getPassword,customer.getPassword())
                .set(Customer::getAddress,customer.getAddress());
        boolean isSuccessful = customerService.update(lambdaQueryWrapper);
        if(isSuccessful){
            return new JsonResult(true,"用户信息修改成功");
        }
        else {
            return new JsonResult(false,"用户信息修改失败");
        }
    }

    //用户充值后增加balance

}
