package com.mason.mooc.algo.utils;

import java.util.List;

/**
 * Created by mwu on 2019/9/16
 */
public interface ISort {
  <T extends Comparable<? super T>> void sort(List<T> list, Boolean isAscending);

  void sort(int[] array, Boolean isAscending);
}
