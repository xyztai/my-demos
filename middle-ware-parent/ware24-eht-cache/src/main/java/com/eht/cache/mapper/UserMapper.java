package com.eht.cache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eht.cache.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
