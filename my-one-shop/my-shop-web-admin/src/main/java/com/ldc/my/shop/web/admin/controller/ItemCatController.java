package com.ldc.my.shop.web.admin.controller;

import com.google.common.collect.Lists;
import com.ldc.my.shop.web.admin.abstracts.AbstractTreeBaseController;
import com.ldc.my.shop.web.admin.entity.ItemCat;
import com.ldc.my.shop.web.admin.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "item/cat")
public class ItemCatController extends AbstractTreeBaseController<ItemCat, ItemCatService> {

    @GetMapping(value = "list")
    public String list(Model model){
        List<ItemCat> itemCats = service.selectAll();
        ArrayList<ItemCat> targertList = Lists.newArrayList();
        //排序
        sort(0L,itemCats,targertList);
        model.addAttribute("list",targertList);

        return "item/cat/list";
    }
    @Autowired
    private ItemCatService itemCatService;


    @GetMapping(value = "delete")
    public String delete(Long id, RedirectAttributes redirectAttributes){
        itemCatService.delete(id);
        addMessage(redirectAttributes, "删除用户成功");
        return "redirect:/item/cat/list";
    }

    /**
     * 携带数据并跳转
     */
    @GetMapping(value = "form")
    public String form(ItemCat itemCat){
        // 设置默认为根节点
        if (itemCat.getParentId() == null) {
            itemCat.setParentId(0L);
        }
        // 设置默认为正常
        if (itemCat.getStatus() == null) {
            itemCat.setStatus(1);
        }
        return "item/cat/form";
    }

    /**
     * 修改信息或新增
     * @param itemCat
     * @return
     */
    @PostMapping(value = "save")
    public String save(ItemCat itemCat, RedirectAttributes redirectAttributes){
        // 验证成功
        if (beanValidator(itemCat, redirectAttributes)) {
            itemCatService.save(itemCat);
            addMessage(redirectAttributes, "保存用户成功");

            return "redirect:/item/cat/list";
        }

        // 验证失败
        else {
            return "redirect:item/cat/form";
        }

    }


}
