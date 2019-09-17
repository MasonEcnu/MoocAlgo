package com.mason.mooc.algo.sort;

import com.mason.mooc.algo.utils.ISort;
import com.mason.mooc.algo.utils.SortUtils;

import java.util.List;

/**
 * Created by mwu on 2019/9/16
 * 插入排序
 * 默认升序
 * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * 1.第一个元素，认为有序
 * 2.下一个元素，在有序序列中从后往前扫描
 * 3.如果已有元素大于新元素，则后移
 * 4.重复3步骤，直到找到新元素的位置
 * 5.插入新元素
 * 6.重复2-5步骤，直到排序完毕
 * 算法分析
 * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 */
public class InsertionSort implements ISort {
  @Override
  public <T extends Comparable<? super T>> void sort(List<T> list, Boolean isAscending) {
    if (list.size() > 1) {
      int size = list.size();
      T current;
      for (int i = 0; i < size - 1; i++) {
        current = list.get(i + 1);
        int preIndex = i;
        if (isAscending) {
          // 升序
          while (preIndex >= 0 && current.compareTo(list.get(preIndex)) < 0) {
            list.set(preIndex + 1, list.get(preIndex));
            preIndex--;
          }
          list.set(preIndex + 1, current);
        } else {
          // 降序
          while (preIndex >= 0 && current.compareTo(list.get(preIndex)) > 0) {
            list.set(preIndex + 1, list.get(preIndex));
            preIndex--;
          }
          list.set(preIndex + 1, current);
        }
      }
    }
  }

  @Override
  public void sort(int[] array, Boolean isAscending) {
    if (array.length > 1) {
      int size = array.length;
      for (int i = 0; i < size - 1; i++) {
        int current = array[i + 1];
        int preIndex = i;
        if (isAscending) {
          while (preIndex >= 0 && current < array[preIndex]) {
            array[preIndex + 1] = array[preIndex];
            preIndex--;
          }
          array[preIndex + 1] = current;
        } else {
          while (preIndex >= 0 && current > array[preIndex]) {
            array[preIndex + 1] = array[preIndex];
            preIndex--;
          }
          array[preIndex + 1] = current;
        }
      }
    }
  }

  public static void main(String[] args) {
    InsertionSort insertionSort = new InsertionSort();
    List<Integer> list = SortUtils.randomIntList(10, 10);
    SortUtils.execSort(insertionSort, list, true);

    int[] array = SortUtils.randomIntArray(10, 10);
    SortUtils.execSort(insertionSort, array, false);
  }
}
