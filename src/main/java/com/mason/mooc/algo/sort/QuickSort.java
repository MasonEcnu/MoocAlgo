package com.mason.mooc.algo.sort;

import com.alibaba.fastjson.JSON;
import com.mason.mooc.algo.utils.ISort;
import com.mason.mooc.algo.utils.SortUtils;

import java.util.List;
import java.util.Random;

/**
 * Created by mwu on 2019/9/18
 * 快速排序
 * 默认升序
 * 分治法
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
 * 则可分别对这两部分记录继续进行排序，以达到整个序列有序
 * 1.从序列中选出一个基准，pivot
 * 2.分区，将小于基准的放到序列前面，大于的放到序列后面
 * 完毕后，基准位于最终排序位置，该操作成为分区partition
 * 3.递归执行1、2步骤
 * 算法分析
 * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)
 */
public class QuickSort implements ISort {

  @Override
  public <T extends Comparable<? super T>> void sort(List<T> list, boolean isAscending) {
    sort(list, 0, list.size() - 1, isAscending);
  }

  private <T extends Comparable<? super T>> void sort(List<T> list, int start, int end, Boolean isAscending) {
    if (list.size() < 1 || start < 0 || end >= list.size() || start > end) return;
    int smallIndex = partition(list, start, end, isAscending);
    if (smallIndex > start) {
      sort(list, start, smallIndex - 1, isAscending);
    }
    if (smallIndex < end) {
      sort(list, smallIndex + 1, end, isAscending);
    }
  }

  private <T extends Comparable<? super T>> int partition(List<T> list, int start, int end, Boolean isAscending) {
    int pivot = (int) (start + Math.random() * (end - start + 1));
    int smallIndex = start - 1;
    SortUtils.swap(list, pivot, end);
    for (int i = start; i <= end; i++) {
      int compare = list.get(i).compareTo(list.get(end));
      boolean flag = isAscending ? compare <= 0 : compare >= 0;
      if (flag) {
        smallIndex++;
        if (i > smallIndex) {
          SortUtils.swap(list, i, smallIndex);
        }
      }
    }
    return smallIndex;
  }

  @Override
  public void sort(int[] array, boolean isAscending) {
    sort(array, 0, array.length - 1, isAscending);
  }

  private void sort(int[] array, int start, int end, boolean isAscending) {
    if (array.length < 1 || start < 0 || end >= array.length || start > end) return;
    int smallIndex = partition(array, start, end, isAscending);
    if (smallIndex > start)
      sort(array, start, smallIndex - 1, isAscending);
    if (smallIndex < end)
      sort(array, smallIndex + 1, end, isAscending);
  }

  private int partition(int[] array, int start, int end, boolean isAscending) {
    int pivot = (int) (start + Math.random() * (end - start + 1));
    int smallIndex = start - 1;
    SortUtils.swap(array, pivot, end);
    for (int i = start; i <= end; i++) {
      int compare = array[i] - array[end];
      boolean flag = isAscending ? compare <= 0 : compare >= 0;
      if (flag) {
        smallIndex++;
        if (i > smallIndex)
          SortUtils.swap(array, i, smallIndex);
      }
    }
    return smallIndex;
  }

  public static void main(String[] args) {
    QuickSort quickSort = new QuickSort();
    List<Integer> list = SortUtils.randomIntList(10, 10);
    SortUtils.execSort(quickSort, list, false);

    int[] array = SortUtils.randomIntArray(10, 10);
    SortUtils.execSort(quickSort, array, false);
  }
}