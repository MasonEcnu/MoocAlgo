package com.mason.mooc.algo.utils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mwu on 2019/9/11
 * 需要用到的工具类
 */
public class SortUtils {

  private static Random random = new Random();

  public static List<Integer> randomIntList(int length, int max) {
    List<Integer> list = new ArrayList<>(length);
    for (int i = 0; i < length; i++) {
      list.add(random.nextInt(max));
    }
    return list;
  }

  public static int[] randomIntArray(int length, int max) {
    int[] array = new int[length];
    for (int i = 0; i < length; i++) {
      array[i] = random.nextInt(max);
    }
    return array;
  }

  public static <T> void swap(List<T> list, int x, int y) {
    if (!list.get(x).equals(list.get(y))) {
      T temp = list.get(x);
      list.set(x, list.get(y));
      list.set(y, temp);
    }
  }

  public static void swap(int[] array, int x, int y) {
    if (array[x] != array[y]) {
      int temp = array[x];
      array[x] = array[y];
      array[y] = temp;
    }
  }

  // 执行排序
  public static void execSort(ISort iSort, List<Integer> list, boolean isAscending) {
    System.out.println("List排序方式：" + iSort.getClass().getSimpleName());
    System.out.println("List排序前：");
    System.out.println(JSON.toJSONString(list));
    System.out.println("List排序后：");
    long start = System.currentTimeMillis();
    iSort.sort(list, isAscending);
    long end = System.currentTimeMillis();
    System.out.println(JSON.toJSONString(list));
    System.out.println("List排序耗时：" + (end - start) + "ms");
  }

  // 执行排序
  public static void execSort(ISort iSort, int[] array, boolean isAscending) {
    System.out.println("Array排序方式：" + iSort.getClass().getSimpleName());
    System.out.println("Array排序前：");
    System.out.println(JSON.toJSONString(array));
    System.out.println("Array排序后：");
    long start = System.currentTimeMillis();
    iSort.sort(array, isAscending);
    long end = System.currentTimeMillis();
    System.out.println(JSON.toJSONString(array));
    System.out.println("Array排序耗时：" + (end - start) + "ms");
  }
}
