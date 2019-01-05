package com.ldc.my.shop.web.admin.interceptor;

import com.ldc.my.shop.web.admin.constants.SystemConstants;
import com.ldc.my.shop.web.admin.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限管理拦截器
 * <p>Title: PermissionInterceptor</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/28 10:02
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute(SystemConstants.CACHE_KEY_USER);
        // 已登录
        if (user != null) {
            response.sendRedirect("/main");
            return false;
        }

        // 返回登录页
        else {
            return true;
        }
    }
}
