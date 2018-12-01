package com.zx.yuren.internal.strength.algorithm.sort.strategy;

import com.zx.yuren.internal.strength.algorithm.sort.Sort;
import com.zx.yuren.internal.strength.algorithm.sort.util.ArrayUtil;

/**
 * 堆排序算法
 * @author xu.qiang
 */
public class HeapSort implements Sort {
    private static <T extends Comparable<T>> void adjustHeat(T[] array, int parent, int length) {
        // temp保存当前父节点
        T temp = array[parent];
        // 先获得左孩子
        int child = 2 * parent + 1;

        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child].compareTo(array[child + 1]) < 0) {
                child++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp.compareTo(array[child]) >= 0) {
                break;
            }

            // 把孩子结点的值赋给父结点
            array[parent] = array[child];

            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }

        array[parent] = temp;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        // 循环建立初始堆
        for (int i = list.length / 2; i >= 0; i--) {
            adjustHeat(list, i, list.length);
        }

        // 进行n-1次循环，完成排序
        for (int i = list.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            T temp = list[i];
            list[i] = list[0];
            list[0] = temp;

            // 筛选 R[0] 结点，得到i-1个结点的堆
            adjustHeat(list, 0, i);

            ArrayUtil.debugLogArray(list, 0, list.length - 1, String.format("第 %d 趟：", list.length - i));
        }
    }
}
