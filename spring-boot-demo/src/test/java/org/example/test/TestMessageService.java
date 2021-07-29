package org.example.test;

import com.javat.SpringbootApp;
import com.javat.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Author tai
 * @create 2021-07-29 13:51
 */
@SpringBootTest(classes = SpringbootApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Slf4j
public class TestMessageService {
    @Autowired
    private IMessageService messageService;

    @Test
    public void testEcho(){
        log.info(messageService.echo("well"));
    }

}
