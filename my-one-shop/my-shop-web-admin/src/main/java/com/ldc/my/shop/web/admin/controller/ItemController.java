package com.ldc.my.shop.web.admin.controller;

import com.ldc.my.shop.web.admin.abstracts.AbstractBaseController;
import com.ldc.my.shop.web.admin.entity.Item;
import com.ldc.my.shop.web.admin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *商品管理控制器
 * <p>Title: ItemController.java</p>
 * <p>Description: </p>
 *
 * @author ldc
 * @version 1.0.0
 * @date 2018/12/11
 */
@Controller
@RequestMapping(value = "/item")
public class ItemController extends AbstractBaseController<Item, ItemService> {

    @Autowired
    private ItemService itemService;
    /**
     * 跳转列表页
     *
     * @return
     */
    @GetMapping(value = "list")
    public String list() {
        return "item/list";
    }

    /**
     * 携带数据并跳转
     */
    @GetMapping(value = "form")
    public String form(){
        return "item/form";
    }
    /**
     * 修改信息或新增
     * @param item
     * @return
     */
    @PostMapping(value = "save")
    public String save(Item item, RedirectAttributes redirectAttributes){
        // 验证成功
        if (beanValidator(item, redirectAttributes)) {
            itemService.save(item);
            addMessage(redirectAttributes, "保存用户成功");
            return "redirect:/item/list";
        }

        // 验证失败
        else {
            return "redirect:/item/form";
        }

    }

    @GetMapping(value = "delete")
    public String delete(Long id,RedirectAttributes redirectAttributes){
        itemService.delete(id);
        addMessage(redirectAttributes, "删除用户成功");
        return "redirect:/item/list";
    }



}
