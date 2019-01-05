package com.ldc.my.shop.web.admin.service.impl;

import com.ldc.my.shop.web.admin.abstracts.impl.AbstractTreeBaseCrudServiceImpl;
import com.ldc.my.shop.web.admin.entity.ItemCat;
import com.ldc.my.shop.web.admin.mapper.ItemCatMapper;
import com.ldc.my.shop.web.admin.service.ItemCatService;
import org.springframework.stereotype.Service;

@Service
public class ItemCatServiceImpl extends AbstractTreeBaseCrudServiceImpl<ItemCat, ItemCatMapper>implements ItemCatService {
}
