package com.junit.tool;

import cn.hutool.json.JSONUtil;
import com.junit.tool.entity.Activity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 基于TestRestTemplate测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActivityTest01 {

    protected static Logger logger = LoggerFactory.getLogger(ActivityTest01.class) ;

    @Resource
    private TestRestTemplate restTemplate;

    private Activity activity = null ;

    @Before
    public void before (){
        activity = restTemplate.getForObject("/activity/{id}", Activity.class,1);
        logger.info("\n"+JSONUtil.toJsonPrettyStr(activity));
    }

    @Test
    public void updateById (){
        if (activity != null){
            activity.setCreateTime(new Date());
            activity.setOrganizer("One商家");
            restTemplate.put("/activity",activity);
        }
    }

    @After
    public void after (){
        activity = restTemplate.getForObject("/activity/{id}", Activity.class,1);
        logger.info("\n"+JSONUtil.toJsonPrettyStr(activity));
        activity = null ;
    }
}
