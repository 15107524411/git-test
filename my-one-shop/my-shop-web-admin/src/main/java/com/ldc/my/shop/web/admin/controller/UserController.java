package com.ldc.my.shop.web.admin.controller;

import com.ldc.my.shop.web.admin.abstracts.AbstractBaseController;
import com.ldc.my.shop.web.admin.commons.PageInfo;
import com.ldc.my.shop.web.admin.dto.DataTable;
import com.ldc.my.shop.web.admin.entity.User;
import com.ldc.my.shop.web.admin.service.UserService;
import com.ldc.my.shop.web.admin.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理
 * <p>Title: UserController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/12/5 9:26
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractBaseController<User,UserService> {

    @Autowired
    private UserService userService;


    @GetMapping(value = "delete")
    public String delete(Long id,RedirectAttributes redirectAttributes){
        userService.delete(id);
        addMessage(redirectAttributes, "删除用户成功");
        return "redirect:/user/list";
    }
    /**
     * 跳转列表页
     *
     * @return
     */
    @GetMapping(value = "list")
    public String list() {
        return "user/list";
    }

    /**
     * 携带数据并跳转
     */
    @GetMapping(value = "form")
    public String form(){
        return "user/form";
    }

    /**
     * 修改信息或新增
     * @param user
     * @return
     */
    @PostMapping(value = "save")
    public String save(User user, RedirectAttributes redirectAttributes){
        // 验证成功
        if (beanValidator(user, redirectAttributes)) {
            userService.save(user);
            addMessage(redirectAttributes, "保存用户成功");
            return "redirect:/user/list";
        }

        // 验证失败
        else {
            return "redirect:/user/form";
        }

    }



}
