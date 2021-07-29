package org.example.test;

import com.javat.SpringbootApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author tai
 * @create 2021-07-29 13:52
 */
@SpringBootTest(classes = SpringbootApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Slf4j
public class TestDataSource {
    @Autowired
    private DataSource c3p0DataSource;

    @Autowired
    private DataSource druidDataSource;

    @Test
    public void testC3P0Conn() throws SQLException {
        log.info(String.valueOf(c3p0DataSource.getConnection()));
    }

    @Test
    public void testDruidConn() throws SQLException {
        log.info(String.valueOf(druidDataSource.getConnection()));
    }
}

