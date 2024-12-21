package com.hust.online_bookstore_backend.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * 封装一个实体类
 * 用于统一响应客户端
 * {
 *     result:true|false,
 *     errCode:错误的状态码
 *     msg:"提示信息",
 *     data:[]|{}|值
 * }
 *
 */
@Data
public class JsonResult {

    private Boolean result;
    private String errCode;
    private String msg;
    private Object data;
    public JsonResult() {
    }
    public JsonResult(Object data) {
        this.result=true;
        this.data = data;
    }
    public JsonResult(boolean rs, String msg){
        this.result=rs;
        this.msg=msg;
    }

    public JsonResult(boolean rs, Object data, String msg){
        this.result=rs;
        this.data=data;
        this.msg=msg;
    }
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
