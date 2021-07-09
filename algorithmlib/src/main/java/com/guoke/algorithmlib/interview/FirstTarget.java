package com.guoke.algorithmlib.interview;

/**
 * 字节三面
 * 在一个有序的素组里，找到 target 第一次出现的位置下标
 */
public class FirstTarget {

    public static void main(String[] args){

        int[] arr = new int[]{1,2,2,3,4,4,5,6,6};

        fun2(arr,8,0,arr.length - 1);

    }

    // 跳表

    // 二分查找
    private static void fun2(int[] arr,int target,int begin,int end){

        if(begin == end){
            if(arr[begin] == target){
                System.out.print("" + begin);
            }else{
                System.out.print("" + -1);
            }
            return;
        }

        int mid = (begin + end) / 2;

        if(target <= arr[mid]){
            fun2(arr,target,begin,mid);
        }else{
            fun2(arr,target,mid + 1,end);
        }

    }
}
