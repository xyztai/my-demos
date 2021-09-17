package com.javat.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @Author tai
 * @create 2021-09-17 19:23
 */
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String userName;
    private String password;
    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;
}
