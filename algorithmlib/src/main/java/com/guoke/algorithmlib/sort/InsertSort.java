package com.guoke.algorithmlib.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {

        int[] arr = {6, 1, 2, 7, 9, 11, 4, 5, 10, 8};
        System.out.println("原始数据: " + Arrays.toString(arr));
        customInsertSort(arr);
        System.out.println("插入排序: " + Arrays.toString(arr));

    }

    // 形象比喻：
    // 0、...、x、(x+1)、...、(j-1),j
    // 0 - (j-1) 区间已排好序（小到大），
    // 当扫描到 x 小于 j，就把 j 插入到(x+1)的位置，(x+1) - (j-1) 区间往右挪一位
    public static void customInsertSort(int[] arr){
        // 认为左边第一位已经排好序，从第二位开始往有序子序列中插入
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i]; // 待插入待数据
            int j = i;         // 从左边排好序的右边一位开始
            for(; j > 0; j--){ // 跟左边排好序的逐一比较，扫面区间是 0 <-（j-1），逐个跟 j 位置的比。
                if(arr[j-1] > temp){   // 扫到的数据，比待插入数据大
                    arr[j] = arr[j-1]; // 右挪一位
                }else{
                    break; // 找到位置，记录在 j 中
                }
            }
            arr[j] = temp; // 插入
        }
    }
}
