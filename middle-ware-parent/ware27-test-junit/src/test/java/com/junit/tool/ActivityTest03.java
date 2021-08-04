package com.junit.tool;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.junit.tool.entity.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 模拟Http请求
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ActivityTest03 {

    protected static Logger logger = LoggerFactory.getLogger(ActivityTest03.class) ;

    protected static String REQ_URL = "http://localhost:8088/";

    @Test
    public void testHttp (){
        // 查询
        String getRes = HttpUtil.get(REQ_URL+"activity/1");
        logger.info("\n {} ",JSONUtil.toJsonPrettyStr(getRes));
        Activity activity = JSONUtil.toBean(getRes, Activity.class) ;
        // 新增
        activity.setId(null);
        activity.setOrganizer("Http商家");
        String saveRes = HttpUtil.post(REQ_URL+"/activity",JSONUtil.toJsonStr(activity));
        logger.info("\n {} ",saveRes);
        // 更新
        activity.setId(Integer.parseInt(saveRes));
        activity.setOrganizer("Put商家");
        String putRes = HttpRequest.put(REQ_URL+"/activity")
                .body(JSONUtil.toJsonStr(activity)).execute().body();
        logger.info("\n {} ",putRes);
    }

}
