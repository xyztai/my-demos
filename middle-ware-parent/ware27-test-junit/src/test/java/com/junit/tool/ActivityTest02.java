package com.junit.tool;

import cn.hutool.json.JSONUtil;
import com.junit.tool.entity.Activity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import javax.annotation.Resource;
import java.util.Date;

/**
 * 基于MockMvc测试
 */
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ActivityTest02 {
    protected static Logger logger = LoggerFactory.getLogger(ActivityTest02.class) ;
    @Resource
    private MockMvc mockMvc ;

    private Activity activity = null ;

    @Before
    public void before () throws Exception {
        ResultActions resultAction = mockMvc.perform(MockMvcRequestBuilders.get("/activity/{id}",1)) ;
        MvcResult mvcResult = resultAction.andReturn() ;
        String result = mvcResult.getResponse().getContentAsString();
        activity = JSONUtil.toBean(result,Activity.class) ;
    }

    @Test
    public void updateById () throws Exception {
        activity.setId(null);
        activity.setCreateTime(new Date());
        activity.setOrganizer("One商家");
        ResultActions resultAction = mockMvc.perform(MockMvcRequestBuilders.post("/activity")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(JSONUtil.toJsonStr(activity))) ;
        MvcResult mvcResult = resultAction.andReturn() ;
        String result = mvcResult.getResponse().getContentAsString();
        activity.setId(Integer.parseInt(result));
        logger.info("result : {} ",result);
    }

    @After
    public void after () throws Exception {
        activity.setCreateTime(new Date());
        activity.setOrganizer("Update商家");
        ResultActions resultAction = mockMvc.perform(MockMvcRequestBuilders.put("/activity")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONUtil.toJsonStr(activity))) ;
        MvcResult mvcResult = resultAction.andReturn() ;
        String result = mvcResult.getResponse().getContentAsString();
        logger.info("result : {} ",result);
    }
}
