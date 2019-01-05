package com.ldc.my.shop.web.admin.utils;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 缓存工具类
 * <p>Title: CacheUtils</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/11/27 9:08
 */
public final class CacheUtils {
    private static Map<String, Object> cacheMap = Maps.newHashMap();

    /**
     * 将输入放入缓存
     *
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {
        cacheMap.put(key, value);
    }

    /**
     * 从缓存中获取数据
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        return cacheMap.get(key);
    }

    /**
     * 根据键删除缓存项
     *
     * @param key
     */
    public static void remove(String key) {
        cacheMap.remove(key);
    }

    /**
     * 清除缓存
     */
    public static void clear() {
        cacheMap.clear();
    }
}
