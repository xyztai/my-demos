package com.junit.tool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junit.tool.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

}