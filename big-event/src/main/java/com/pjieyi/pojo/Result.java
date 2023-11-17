package com.pjieyi.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//统一结果封装
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;  //响应状态码 0-成功 1-失败
    private String message; //响应信息
    private T data;  //响应数据

    //快速返回操作成功 (带响应数据)
    public static <E> Result<E> success(E data){
        return new Result<>(0,"操作成功",data);
    }

    //快速返回操作成功 (不带响应数据)
    public static Result success(){
        return new Result(0,"操作成功",null);
    }

    //快速返回操作失败
    public static Result error(){
        return new Result(1,"操作失败",null);
    }

}
