package com.javat.advice;

import com.javat.bean.ResultExceptionBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author tai
 * @create 2021-07-29 13:33
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {
    public static final int DEFAULT_ERROR_CODE = 100;

    @ExceptionHandler(Exception.class)
    public ResultExceptionBean handleException(HttpServletRequest request, HttpServletResponse response, Exception e){
        return new ResultExceptionBean("101", e.getMessage());
    }

}
