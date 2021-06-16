package com.guoke.algorithmlib.sort;

import java.util.Arrays;

public class PopSort {
    public static void main(String[] args) {

        int[] arr = {6, 1, 2, 7, 9, 11, 4, 5, 10, 8};
        System.out.println("原始数据: " + Arrays.toString(arr));
        customPopSort(arr);
        System.out.println("冒泡排序: " + Arrays.toString(arr));

    }

    public static void customPopSort(int[] arr){
        int temp;
        for(int i = 0; i < arr.length; i++){ // 从左往右扫
            for(int j = arr.length - 1; j > i; j--){ // 从右往左扫
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }// 本质是：每一轮，都把最小值换到最左边
        }
    }
}
