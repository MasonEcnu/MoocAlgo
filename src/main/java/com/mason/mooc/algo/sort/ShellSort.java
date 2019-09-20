package com.mason.mooc.algo.sort;

import com.mason.mooc.algo.utils.ISort;
import com.mason.mooc.algo.utils.SortUtils;

import java.util.List;

/**
 * Created by mwu on 2019/9/17
 * 希尔排序
 * 默认升序
 * 缩小增量排序
 * 希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
 * 希尔增量
 * gap=length/2, gap = gap/2
 * 1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1
 * 2.按增量序列个数k，对序列进行k 趟排序
 * 3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * 算法分析
 * 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)
 */
public class ShellSort implements ISort {
  @Override
  public <T extends Comparable<? super T>> void sort(List<T> list, boolean isAscending) {
    if (list.size() > 1) {
      int size = list.size();
      T temp;
      int gap = size / 2;
      while (gap > 0) {
        for (int i = gap; i < size; i++) {
          int preIndex = i - gap;
          temp = list.get(i);
          if (isAscending) {
            while (preIndex >= 0 && temp.compareTo(list.get(preIndex)) < 0) {
              list.set(preIndex + gap, list.get(preIndex));
              preIndex -= gap;
            }
            list.set(preIndex + gap, temp);
          } else {
            while (preIndex >= 0 && temp.compareTo(list.get(preIndex)) > 0) {
              list.set(preIndex + gap, list.get(preIndex));
              preIndex -= gap;
            }
            list.set(preIndex + gap, temp);
          }
        }
        gap /= 2;
      }
    }
  }

  @Override
  public void sort(int[] array, boolean isAscending) {
    if (array.length > 1) {
      int size = array.length;
      int temp, gap = size / 2;
      while (gap > 0) {
        for (int i = gap; i < size; i++) {
          int preIndex = i - gap;
          temp = array[i];
          if (isAscending) {
            while (preIndex >= 0 && temp < array[preIndex]) {
              array[preIndex + gap] = array[preIndex];
              preIndex -= gap;
            }
            array[preIndex + gap] = temp;
          } else {
            while (preIndex >= 0 && temp > array[preIndex]) {
              array[preIndex + gap] = array[preIndex];
              preIndex -= gap;
            }
            array[preIndex + gap] = temp;
          }
        }
        gap /= 2;
      }
    }
  }

  public static void main(String[] args) {
    ShellSort shellSort = new ShellSort();
    List<Integer> list = SortUtils.randomIntList(10, 10);
    SortUtils.execSort(shellSort, list, true);

    int[] array = SortUtils.randomIntArray(10, 10);
    SortUtils.execSort(shellSort, array, false);
  }
}
