package com.junit.tool;

import com.junit.tool.entity.Activity;
import com.junit.tool.service.ActivityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 服务层方法测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ActivityTest04 {

    protected static Logger logger = LoggerFactory.getLogger(ActivityTest04.class) ;

    @Autowired
    private ActivityService activityService ;

    @Test
    public void testService (){
        // 查询
        Activity activity = activityService.getById(1) ;
        // 新增
        activity.setId(null);
        activityService.save(activity) ;
        // 修改
        activity.setOrganizer("Ser商家");
        activityService.updateById(activity) ;
        // 删除
        activityService.removeById(activity.getId()) ;
    }
}
