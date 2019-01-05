package com.ldc.my.shop.web.admin.abstracts;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public abstract class AbstractTreeBaseController <T extends AbstractTreeBaseEntity,S extends BaseTreeCrudService<T>> extends AbstractBaseController <T,S>{

    /**
     * 树形结构排序
     * @param parentId 父节点 ID
     * @param sortList 源数据
     * @param targetList 目标数据
     * @return
     */
    protected List<T>sort(Long parentId,List<T>sortList,List<T>targetList){
        for (T entity :sortList) {
            if (entity.getParentId().equals(parentId)){
                targetList.add(entity);
                sort(entity.getId(),sortList,targetList);
            }
        }
        return targetList;
    }

    /**
     * 通过前面闯过来的id获取
     * @param parentId
     * @return
     */
    @ResponseBody
    @PostMapping(value = "tree")
    protected List<T>getParentId(Long parentId){
        List<T> list = Lists.newArrayList();
        // 首次访问直接加载全部根节点
        if(parentId==null){
            list=  service.getByParentId(0L);
        }
        // 根据父级 ID 查询
        else{
            list = service.getByParentId(parentId);
        }
        return list;

    }
}
