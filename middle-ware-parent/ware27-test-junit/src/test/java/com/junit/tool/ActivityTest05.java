package com.junit.tool;

import com.junit.tool.entity.Activity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Set;

/**
 * 基于Mockito测试
 */
@RunWith(PowerMockRunner.class)
@SpringBootTest
public class ActivityTest05 {

    @Test
    public void testMock (){
        Set mockSet = PowerMockito.mock(Set.class);
        PowerMockito.when(mockSet.size()).thenReturn(10);
        int actual = mockSet.size();
        int expected = 15 ;
        Assert.assertEquals("返回值不符合预期",expected, actual);
        /*
         java.lang.AssertionError: 返回值不符合预期
         Expected :15
         Actual   :10
         */
    }

    @Test
    public void testTitle (){
        String expectTitle = "Mock主题" ;
        Activity activity = PowerMockito.mock(Activity.class);
        PowerMockito.when(activity.getMockTitle()).thenReturn(expectTitle);
        String actualTitle = activity.getMockTitle();
        Assert.assertNotEquals("主题相符", expectTitle, actualTitle);
        /*
         java.lang.AssertionError: 主题相符. Actual: Mock主题
         */
    }
}
