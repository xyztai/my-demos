package com.param.check.controller;

import com.param.check.entity.JavaValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CheckWeb {
    protected static Logger logger = LoggerFactory.getLogger(CheckWeb.class);

    @GetMapping("/check/base")
    public String baseCheck (@RequestParam("var") String var){
        if (var == null) {
            return var+" is null" ;
        }
        if ("".equals(var)){
            return var+" is empty" ;
        }
        if ("hello".equals(var)){
            return var+" sensitive word " ;
        }
        return var + " through " ;
    }

    /**
     : CheckRes:邮箱格式异常
     : CheckRes:ID不能为空
     */
    @PostMapping("/java/valid")
    public JavaValid javaValid (@RequestBody @Valid JavaValid javaValid,BindingResult errorMsg){
        if (errorMsg.hasErrors()){
            List<ObjectError> objectErrors = errorMsg.getAllErrors() ;
            objectErrors.stream().forEach(objectError -> {
                logger.info("CheckRes:{}",objectError.getDefaultMessage());
            });
        }
        return javaValid ;
    }
}
