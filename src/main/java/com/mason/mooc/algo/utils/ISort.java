package com.mason.mooc.algo.utils;

import java.util.List;

/**
 * Created by mwu on 2019/9/16
 */
public interface ISort {
  <T extends Comparable<? super T>> void sort(List<T> list, boolean isAscending);

  void sort(int[] array, boolean isAscending);
}
