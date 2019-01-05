package com.ldc.my.shop.web.admin.dto;

import com.ldc.my.shop.web.admin.abstracts.AbstractBaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用于封装 DataTable 数据源
 * <p>Title: DataTable</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/12/6 15:45
 */
@Data
public class DataTable<T extends AbstractBaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
}
