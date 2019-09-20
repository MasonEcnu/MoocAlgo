package com.mason.mooc.algo.sort;

import com.mason.mooc.algo.utils.ISort;
import com.mason.mooc.algo.utils.SortUtils;

import java.util.List;

/**
 * Created by mwu on 2019/9/11
 * 冒泡排序
 * 默认升序
 * 1.比较相邻元素，逆序则交换
 * 2.挨个按一对一对比较，则一轮结束后，最大元素应该位于队尾
 * 3.重复直到有序
 * <p>
 * 算法分析
 * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 */
public class BubbleSort implements ISort {

  @Override
  public <T extends Comparable<? super T>> void sort(List<T> list, boolean isAscending) {
    if (list.size() > 1) {
      int size = list.size();
      for (int i = 0; i < size; i++) {
        for (int j = i + 1; j < size; j++) {
          int compare = list.get(i).compareTo(list.get(j));
          boolean flag = isAscending ? compare > 0 : compare < 0;
          if (flag) {
            SortUtils.swap(list, i, j);
          }
        }
      }
    }
  }

  // 	for (int i = 0; i < array.length; i++)
  //		for (int j = 0; j < array.length - 1 - i; j++)

  @Override
  public void sort(int[] array, boolean isAscending) {
    if (array.length > 1) {
      int size = array.length;
      for (int i = 0; i < size; i++) {
        for (int j = i + 1; j < size; j++) {
          int compare = array[i] - array[j];
          boolean flag = isAscending ? compare > 0 : compare < 0;
          if (flag) {
            SortUtils.swap(array, i, j);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    BubbleSort bubbleSort = new BubbleSort();
    List<Integer> list = SortUtils.randomIntList(100, 100);
    SortUtils.execSort(bubbleSort, list, false);

    int[] array = SortUtils.randomIntArray(100, 100);
    SortUtils.execSort(bubbleSort, array, false);
  }
}
