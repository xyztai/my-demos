package com.param.check.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JavaValid {

    @NotNull(message="ID不能为空")
    private Integer id ;

    @Email(message="邮箱格式异常")
    private String email ;

    @NotEmpty(message = "字段不能为空")
    @Size(min = 2,max = 10,message = "字段长度不合理")
    private String data ;

    public JavaValid(Integer id, String email, String data) {
        this.id = id;
        this.email = email;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
