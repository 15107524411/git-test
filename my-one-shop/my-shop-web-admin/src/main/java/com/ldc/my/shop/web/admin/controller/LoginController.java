package com.ldc.my.shop.web.admin.controller;

import com.ldc.my.shop.web.admin.constants.SystemConstants;
import com.ldc.my.shop.web.admin.entity.User;
import com.ldc.my.shop.web.admin.service.LoginService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/26 10:33
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 跳转到登录页
     *
     * @return
     */
    @GetMapping(value = {"login"})
    public String login() {
        return "login";
    }

    @PostMapping(value = "login")
    public String login(String loginId, String loginPwd, HttpServletRequest request, Model model) {
        User user = loginService.login(loginId, loginPwd);

        // 登录成功
        if (user != null) {
            // 将数据放入缓存
            request.getSession().setAttribute(SystemConstants.CACHE_KEY_USER, user);
            return "redirect:/main";
        }

        // 登录失败
        else {
            model.addAttribute("message", "登录失败，用户名或密码错误");
            return "login";
        }
    }

    /**
     * 注销
     * @param request
     * @return
     */
    @GetMapping(value = "logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
