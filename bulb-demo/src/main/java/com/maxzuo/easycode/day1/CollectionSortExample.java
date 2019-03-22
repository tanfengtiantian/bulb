package com.maxzuo.easycode.day1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections排序测试
 * <p>
 * Created by zfh on 2019/03/22
 */
public class CollectionSortExample {

    @Test
    public void testCollectionsSort() {
        List<Integer> numberList = Arrays.asList(3, 2, 1, 4, 5);

        // TODO: 使用Collections对这个List从大到小进行排序 ？

        Collections.sort(numberList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 < o2 ? 1 : -1;
            }
        });
        System.out.println("numberList: " + numberList);
    }

    /**
     * 扩展：使用jdk8的List.sort()进行排序？
     */
    @Test
    public void ListSort() {
        List<Integer> numberList = Arrays.asList(6, 2, 1, 4, 5);

        numberList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("numberList: " + numberList);
    }

    /**
     * 使用Arrays工具类排序
     */
    @Test
    public void ArraysSort() {
        Integer[] numbers = { 3, 2, 1, 4, 5 };
        Arrays.sort(numbers);
        System.out.println("numbers: " + Arrays.toString(numbers));
    }

    /**
     * Arrays.toString(Object[] args) 源码实现
     */
    @Test
    public void testArraysToString() {
        Integer[] numbers = { 3, 2, 1, 4, 5 };

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0;; i++) {
            stringBuilder.append(numbers[i]).append(",");
            if (i == numbers.length - 1) {
                stringBuilder.append("]");
                break;
            }
        }
        System.out.println("stringBuilder: " + stringBuilder);
    }
}
