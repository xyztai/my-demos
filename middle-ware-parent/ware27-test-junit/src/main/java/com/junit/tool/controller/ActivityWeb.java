package com.junit.tool.controller;

import com.junit.tool.entity.Activity;
import com.junit.tool.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@Api(tags = "活动主体接口")
@RestController
public class ActivityWeb {

    @Resource
    private ActivityService activityService ;

    @ApiOperation("新增活动")
    @PostMapping("/activity")
    public Integer save (@RequestBody Activity activity){
        activityService.save(activity) ;
        return activity.getId() ;
    }

    @ApiOperation("主键查询")
    @GetMapping("/activity/{id}")
    public Activity getById (@PathVariable("id") Integer id){
        return activityService.getById(id) ;
    }

    @ApiOperation("修改活动")
    @PutMapping("/activity")
    public Boolean updateById (@RequestBody Activity activity){
        return activityService.updateById(activity) ;
    }

}
