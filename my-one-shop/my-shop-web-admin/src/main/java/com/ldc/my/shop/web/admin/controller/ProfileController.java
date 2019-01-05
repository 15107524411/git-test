package com.ldc.my.shop.web.admin.controller;

import com.ldc.my.shop.web.admin.abstracts.AbstractBaseController;
import com.ldc.my.shop.web.admin.commons.BeanValidator;
import com.ldc.my.shop.web.admin.constants.SystemConstants;
import com.ldc.my.shop.web.admin.entity.User;
import com.ldc.my.shop.web.admin.service.ProfileService;
import com.ldc.my.shop.web.admin.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 个人信息
 * <p>Title: ProfileController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/28 11:40
 */
@Controller
@RequestMapping(value = "profile")
public class ProfileController   {

    @Autowired
    private ProfileService profileService;

    /**
     * 跳转个人信息页
     *
     * @return
     */
    @GetMapping(value = "info")
    public String info() {
        return "profile/info";
    }

    /**
     * 保存个人信息
     *
     * @return
     */
    @PostMapping(value = "save")
    public String save(User user, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String validator = BeanValidator.validator(user);

        // 表单验证成功
        if (validator!=null) {
            // 保存个人信息
            profileService.save(user);

            // 将更新信息放入 session
            User sessionUser = (User) request.getSession().getAttribute(SystemConstants.CACHE_KEY_USER);
            BeanUtils.copyPropertiesIgnoreNull(user, sessionUser);
            request.getSession().setAttribute(SystemConstants.CACHE_KEY_USER, sessionUser);
            redirectAttributes.addFlashAttribute(SystemConstants.MESSAGE, "保存个人信息成功");
        }

        return "redirect:/profile/info";
    }

    /**
     * 修改密码
     *
     * @param user
     * @param redirectAttributes
     * @return
     */
    @PostMapping(value = "modify/password")
    public String modifyPassword(User user, RedirectAttributes redirectAttributes) {
        boolean flag = true;

        int result = profileService.modifyPassword(user);

        if (result == User.CHECK_FAIL_OLD_PASSWORD) {
            flag = false;
            redirectAttributes.addFlashAttribute(SystemConstants.MESSAGE, "旧密码错误，请重新输入");
        } else if (result == User.CHECK_FAIL_NEW_PASSWORD) {
            flag = false;
            redirectAttributes.addFlashAttribute(SystemConstants.MESSAGE, "新密码不符合规范，请重新输入");

        } else {
            redirectAttributes.addFlashAttribute(SystemConstants.MESSAGE,  "密码修改成功");

        }

        if (flag) {
            return "redirect:/profile/info";
        } else {
            return "redirect:/profile/info#tab_1_3";
        }
    }
}
