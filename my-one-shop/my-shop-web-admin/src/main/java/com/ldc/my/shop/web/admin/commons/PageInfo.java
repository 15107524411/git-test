package com.ldc.my.shop.web.admin.commons;

import com.ldc.my.shop.web.admin.abstracts.AbstractBaseEntity;
import lombok.Data;

import java.util.List;

/**
 * 分页信息
 * <p>Title: PageInfo</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/12/6 16:02
 */
@Data
public class PageInfo<T extends AbstractBaseEntity> {
    private int total;
    private List<T> data;
}
