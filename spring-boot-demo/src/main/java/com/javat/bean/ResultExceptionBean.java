package com.javat.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author tai
 * @create 2021-07-29 13:31
 */
@Data
@AllArgsConstructor
public class ResultExceptionBean {
    private String errorCode;
    private String message;
}
