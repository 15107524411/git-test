package com.ldc.my.shop.web.admin.service.test;

import com.ldc.my.shop.web.admin.commons.PageInfo;
import com.ldc.my.shop.web.admin.entity.User;
import com.ldc.my.shop.web.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSelectAll() {
        List<User> users = userService.selectAll();
        System.out.println(users);
    }

    @Test
    public void testPage() {
        User params = new User();
        params.setUsername("z");
        PageInfo<User> pageInfo = userService.page(params, 0, 5);
        System.out.println(pageInfo);
    }

    @Test
    public  void  no(){
        Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
        String replace = dateStr.trim().replace(" ", "").replace("-", "").replace(":", "");
        Long aLong = Long.valueOf(replace);
        System.out.println(aLong);
    }
}
