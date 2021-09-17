package com.javat.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @Author tai
 * @create 2021-09-17 19:22
 */
@Data
@AllArgsConstructor
public class Role {

    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;

}