package com.mason.mooc.algo.chapter01_basic;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * Created by mwu on 2019/9/5
 * 第一章：基础
 * 第一节：String和Long源码解析
 * 面试题
 */
public class Section01 {
  /*
   * String特性
   * 1.1 不变形
   * 一旦被创建并赋值，就不可修改
   * 若没修改，则会创建新类
   * 100.96.194.204
   */

  public static void main(String[] args) {
    Section01 section01 = new Section01();
//    section01.testString();
    section01.testLong();
  }

  private void testString() {
    String str = "Hello";
    str = "world";
    System.out.println(str);
    /*
     * 仅从结果来看，只是str的值发生了改变
     * 实际上，str的内存地址也发生了改变
     * public final class String implements java.io.Serializable, Comparable<String>, CharSequence
     * private final char value[]:说明value一旦被赋值，则其内存地址就无法更改
     */

    str = str.substring(1, 2);
    str = str.substring(1);
    /*
     * substring: new String(value, beginIndex, subLen);
     * Arrays.copyOfRange(value, offset, offset+count);
     */

    str.equals("1");
    /*
     * 底层挨个比较String中的char[] value中的值
     */
    str.replace("", "");
    str.replaceAll("", "");
    str.replaceFirst("", "");

    str.split(":");
    // limit:用于限制拆分的结果数
    str.split(":", 2);

    // guava
    String s = ",a, , b c";
    List<String> list = Splitter.on(",")
        .trimResults()  // 去掉空格
        .omitEmptyStrings() // 去掉空值
        .splitToList(s);

    Joiner joiner = Joiner.on(",").skipNulls();
    String result = joiner.join("hello", null, "china");
    System.out.println(result);

    List<String> lists = Lists.newArrayList("hello", "china", null);
    System.out.println(joiner.join(lists));
  }

  private void testLong() {
    /*
     * Long自己实现了一种缓存机制
     * 缓存了从-128到127内的所有Long值
     * 如果在这个范围内，就不会初始化
     * 而是从缓存中取
     */
    Long l1 = 1L;
    Long l2 = 1L;
    System.out.println(l1 == l2); // true

    Long l3 = 1111L;
    Long l4 = 1111L;
    System.out.println(l3 == l4); // false
  }
}