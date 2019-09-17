package com.mason.mooc.algo.sort;

import com.mason.mooc.algo.utils.ISort;
import com.mason.mooc.algo.utils.SortUtils;

import java.util.List;

/**
 * Created by mwu on 2019/9/11
 * 选择排序
 * 默认升序
 * 1.遍历，找出最小的，与第一个交换
 * 2.循环
 * <p>
 * 算法分析
 * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 */
public class SelectionSort implements ISort {

  @Override
  public <T extends Comparable<? super T>> void sort(List<T> list, Boolean isAscending) {
    if (list.size() > 1) {
      int size = list.size();
      for (int i = 0; i < size; i++) {
        int minIndex = i;
        for (int j = i; j < size; j++) {
          int compare = list.get(minIndex).compareTo(list.get(j));
          boolean flag = isAscending ? compare > 0 : compare < 0;
          if (flag) {
            minIndex = j;
          }
        }
        SortUtils.swap(list, i, minIndex);
      }
    }
  }

  @Override
  public void sort(int[] array, Boolean isAscending) {
    if (array.length > 1) {
      int size = array.length;
      for (int i = 0; i < size; i++) {
        int minIndex = i;
        for (int j = i; j < size; j++) {
          int compare = array[minIndex] - array[j];
          boolean flag = isAscending ? compare > 0 : compare < 0;
          if (flag) {
            minIndex = j;
          }
        }
        SortUtils.swap(array, i, minIndex);
      }
    }
  }

  public static void main(String[] args) {
    SelectionSort selectionSort = new SelectionSort();
    List<Integer> list = SortUtils.randomIntList(100, 100);
    SortUtils.execSort(selectionSort, list, false);

    int[] array = SortUtils.randomIntArray(100, 100);
    SortUtils.execSort(selectionSort, array, false);
  }
}
