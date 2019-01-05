package com.ldc.my.shop.web.admin.interceptor;

import com.ldc.my.shop.web.admin.constants.SystemConstants;
import com.ldc.my.shop.web.admin.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * <p>Title: LoginInterceptor</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/26 11:29
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SystemConstants.CACHE_KEY_USER);

        // 尚未登录
        if (user == null) {
            response.sendRedirect("/login");
            flag = false;
        }

        // 已登录
        else {
            flag = true;
        }

        return flag;
    }
}
