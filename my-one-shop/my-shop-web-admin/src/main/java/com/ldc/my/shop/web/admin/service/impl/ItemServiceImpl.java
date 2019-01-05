package com.ldc.my.shop.web.admin.service.impl;

import com.ldc.my.shop.web.admin.abstracts.impl.AbstractBaseCrudServiceImpl;
import com.ldc.my.shop.web.admin.entity.Item;
import com.ldc.my.shop.web.admin.entity.ItemDesc;
import com.ldc.my.shop.web.admin.mapper.ItemDescMapper;
import com.ldc.my.shop.web.admin.mapper.ItemMapper;
import com.ldc.my.shop.web.admin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ItemServiceImpl extends AbstractBaseCrudServiceImpl<Item, ItemMapper> implements ItemService{
    @Autowired
    private ItemDescMapper itemDescMapper;
    @Override
    public void save(Item entity) {
        if(entity.preInsert(entity)){
            Date date = new Date();
            String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
            String replace = dateStr.trim().replace(" ", "").replace("-", "").replace(":", "");
            entity.setId(Long.valueOf(replace));
            preInsertItemDesc(entity);
            itemDescMapper.insert(entity.getItemDesc());

            Mapper.insert(entity);
        }
        else{
            Mapper.update(entity);
            System.out.println(entity.getId());
            preInsertItemDesc(entity);
            itemDescMapper.update(entity.getItemDesc());
        }
    }

    /**
     * 准备商品详情
     *
     * @param item
     */
    private void preInsertItemDesc(Item item) {
        ItemDesc itemDesc = item.getItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setCreated(item.getCreated());
        itemDesc.setUpdated(item.getUpdated());
    }
}
