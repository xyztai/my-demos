package com.param.check;

import com.param.check.entity.JavaValid;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class JavaValidTest {

    private static Validator validator ;

    @BeforeClass
    public static void beforeBuild (){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void checkValid (){
        JavaValid valid = new JavaValid(null,"email","data") ;
        Set<ConstraintViolation<JavaValid>> validateInfo = validator.validate(valid) ;
        // 打印校验结果
        validateInfo.stream().forEach(validObj -> {
            System.out.println("validateInfo："+validObj.getMessage());
        });
        /* 构造方法中的值有两处异常
         java.lang.AssertionError:
         Expected :3
         Actual   :2
         */
        Assert.assertEquals(3,validateInfo.size());
    }
}
