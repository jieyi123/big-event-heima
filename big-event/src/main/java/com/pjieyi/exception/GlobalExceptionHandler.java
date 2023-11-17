package com.pjieyi.exception;

import com.pjieyi.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author pjieyi
 * @Description 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e){
        e.printStackTrace();
        //当有错误信息的时候提示错误信息
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败" );
    }
}
