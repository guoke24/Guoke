package com.guohao.guoke.Algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {6, 1, 2, 7, 9, 11, 4, 5, 10, 8};
        System.out.println("原始数据: " + Arrays.toString(arr));
        customQuickSort(arr, 0, arr.length - 1);
        System.out.println("快速排序: " + Arrays.toString(arr));

    }

    public static void customQuickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low >= high) return; // 迭代结束
        i = low; j = high; temp = arr[low];// 锚点

        while (i < j) {

            // 锚点选在左边，就必须先从右边开始扫描；若换顺序，则结果不对
            // 先看右边，依次往左扫描，直到找到小于锚点的数，停下来
            while ( arr[j] >= temp && i < j) { j--; }
            // 再看左边，依次往右扫描，直到找到大于锚点的数，停下来
            while ( arr[i] <= temp && i < j) { i++; }

            // 两边交换
            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }

        // 此时 i == j，跟锚点交换，因为是从右边先扫，则保证扫到的数比锚点小！
        arr[low] = arr[i];
        arr[i] = temp;

        customQuickSort(arr, low, j - 1);  // 递归调用左半数组
        customQuickSort(arr, j + 1, high); // 递归调用右半数组
    }
}