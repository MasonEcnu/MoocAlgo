package com.mason.mooc.algo.sort;

import com.alibaba.fastjson.JSON;
import com.mason.mooc.algo.utils.SortUtils;

import java.util.*;

/**
 * Created by mwu on 2019/9/17
 * 归并排序
 * 默认升序
 * 归并排序是建立在归并操作上的一种有效的排序算法
 * 分治法（Divide and Conquer）
 * 1.将长度为n的序列，分成两个长度为n/2的序列
 * 2.对两个子序列采用归并排序
 * 3.将两个排序好的子序列合并成一个有序的序列
 * 算法分析
 * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
 */
public class MergeSort {

  public <T extends Comparable<? super T>> List<T> sort(List<T> list, Boolean isAscending) {
    if (list.size() < 2) return list;

    int mid = list.size() / 2;
    List<T> left = list.subList(0, mid);
    List<T> right = list.subList(mid, list.size());
    return merge(sort(left, isAscending), sort(right, isAscending), isAscending);
  }

  private <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right, Boolean isAscending) {
    int totalSize = left.size() + right.size();
    List<T> result = new ArrayList<>(totalSize);
    for (int index = 0, i = 0, j = 0; index < totalSize; index++) {
      if (i >= left.size())
        result.add(index, right.get(j++));
      else if (j >= right.size())
        result.add(index, left.get(i++));
      else if (isAscending ? left.get(i).compareTo(right.get(j)) > 0 : left.get(i).compareTo(right.get(j)) < 0)
        result.add(index, right.get(j++));
      else
        result.add(index, left.get(i++));
    }

//    int index = 0;
//    int i = 0, j = 0;
//    if (isAscending) {
//      while (i < left.size() && j < right.size()) {
//        int compare = left.get(i).compareTo(right.get(j));
//        if (compare == 0) {
//          result.add(index++, left.get(i));
//          result.add(index++, right.get(j));
//          j++;
//          i++;
//        } else if (compare > 0) {
//          result.add(index++, right.get(j));
//          j++;
//        } else {
//          result.add(index++, left.get(i));
//          i++;
//        }
//      }
//
//      while (i < left.size()) {
//        result.add(index++, left.get(i));
//        i++;
//      }
//
//      while (j < right.size()) {
//        result.add(index++, right.get(j));
//        j++;
//      }
//    } else {
//      while (i < left.size() && j < right.size()) {
//        int compare = left.get(i).compareTo(right.get(j));
//        if (compare == 0) {
//          result.add(index++, left.get(i));
//          result.add(index++, right.get(j));
//          j++;
//          i++;
//        } else if (compare > 0) {
//          result.add(index++, left.get(i));
//          i++;
//        } else {
//          result.add(index++, right.get(j));
//          j++;
//        }
//      }
//
//      while (i < left.size()) {
//        result.add(index++, left.get(i));
//        i++;
//      }
//
//      while (j < right.size()) {
//        result.add(index++, right.get(j));
//        j++;
//      }
//    }
    return result;
  }

  public int[] sort(int[] array, Boolean isAscending) {
    if (array.length < 2) return array;
    int mid = array.length / 2;
    int[] left = Arrays.copyOfRange(array, 0, mid);
    int[] right = Arrays.copyOfRange(array, mid, array.length);

    return merge(sort(left, isAscending), sort(right, isAscending), isAscending);
  }

  private int[] merge(int[] left, int[] right, Boolean isAscending) {
    int totalSize = left.length + right.length;
    int[] result = new int[totalSize];
    for (int index = 0, i = 0, j = 0; index < totalSize; index++) {
      if (i >= left.length) {
        result[index] = right[j++];
      } else if (j >= right.length) {
        result[index] = left[i++];
      } else if (isAscending ? left[i] > right[j] : left[i] < right[j]) {
        result[index] = right[j++];
      } else {
        result[index] = left[i++];
      }
    }
    return result;
  }


  public static void main(String[] args) {
    MergeSort mergeSort = new MergeSort();
//    List<Integer> list = SortUtils.randomIntList(10, 10);
//    System.out.println("List排序前：");
//    System.out.println(JSON.toJSONString(list));
//    System.out.println("List排序后：");
//    long start = System.currentTimeMillis();
//    List<Integer> result = mergeSort.sort(list, true);
//    long end = System.currentTimeMillis();
//    System.out.println(JSON.toJSONString(result));
//    System.out.println("List排序耗时：" + (end - start) + "ms");

    int[] array = SortUtils.randomIntArray(10, 10);
    System.out.println("Array排序前：");
    System.out.println(JSON.toJSONString(array));
    System.out.println("Array排序后：");
    long start = System.currentTimeMillis();
    int[] result = mergeSort.sort(array, true);
    long end = System.currentTimeMillis();
    System.out.println(JSON.toJSONString(result));
    System.out.println("Array排序耗时：" + (end - start) + "ms");
  }
}
