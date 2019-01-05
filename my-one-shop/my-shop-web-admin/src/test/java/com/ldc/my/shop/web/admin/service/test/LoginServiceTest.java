package com.ldc.my.shop.web.admin.service.test;

import com.ldc.my.shop.web.admin.entity.User;
import com.ldc.my.shop.web.admin.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void testLogin() {
        User user = loginService.login("topsale@vip.qq.com", "123456");
        System.out.println(user);
    }
}
