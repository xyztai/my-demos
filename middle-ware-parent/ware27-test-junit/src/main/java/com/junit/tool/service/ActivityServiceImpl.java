package com.junit.tool.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junit.tool.entity.Activity;
import com.junit.tool.mapper.ActivityMapper;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

}
