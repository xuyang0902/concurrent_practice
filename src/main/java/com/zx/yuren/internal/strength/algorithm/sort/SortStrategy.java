package com.zx.yuren.internal.strength.algorithm.sort;

import com.zx.yuren.internal.strength.algorithm.sort.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用策略模式，对算法进行包装
 *
 * @author Zhang Peng
 */
public class SortStrategy {
    private Sort sort;

    public SortStrategy(Sort sort) {
        this.sort = sort;
    }

    public void sort(Integer[] list) {
        System.out.println(this.sort.getClass().getSimpleName() + " 排序开始：");
        System.out.println("排序前: " + ArrayUtil.getArrayString(list, 0, list.length - 1));
        this.sort.sort(list);
        System.out.println("排序后: " + ArrayUtil.getArrayString(list, 0, list.length - 1));
    }
}
