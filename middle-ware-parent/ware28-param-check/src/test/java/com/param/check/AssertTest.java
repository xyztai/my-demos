package com.param.check;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AssertTest {

    private String varObject ;

    @Before
    public void before (){
        varObject = RandomUtil.randomString(6) ;
    }

    @Test
    public void testEquals (){
        Assert.assertEquals(varObject+"不匹配",varObject,RandomUtil.randomString(6));
    }

    @Test
    public void testEmpty (){
        Assert.assertTrue(StrUtil.isNotEmpty(varObject));
        Assert.assertFalse(varObject+" not empty",StrUtil.isNotEmpty(varObject));
    }

    @Test
    public void testArray (){
        /*
            数组元素不相等: arrays first differed at element [1];
            Expected :u08
            Actual   :mwm
         */
        String var = RandomUtil.randomString(5) ;
        String[] arrOne = new String[]{var,RandomUtil.randomString(3)} ;
        String[] arrTwo = new String[]{var,RandomUtil.randomString(3)} ;
        Assert.assertArrayEquals("数组元素不相等",arrOne,arrTwo);
    }
}
