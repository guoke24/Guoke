package com.guoke.algorithmlib.interview;

import java.util.PriorityQueue;

/**
 * 字节二面
 * 第 K 大的数字
 */
public class KNum {

    public static void main(String[] args){

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        fun2(arr,9);
    }

    // 优先队列
    private static void fun1(int[] arr,int k){
        // 找到第k大的值
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++){

            int num = arr[i];

            if(priorityQueue.size() < k){
                priorityQueue.offer(num);
            }else{
                Integer top = priorityQueue.peek();
                if( num > top ){
                    priorityQueue.poll();
                    priorityQueue.offer(num);
                }
            }
        }

        System.out.print("第 " + k + " 大的数：" + priorityQueue.peek());
    }

    // 选择排序
    private static void fun2(int[] arr,int k){

        int len = arr.length;
        int max = arr[0];
        int temp = 0;
        int index = 0;

        for(int i = 0; i < k; i++){
            max = arr[i];
            for(int j = i; j < len; j++){
                if(arr[j] > max){
                    max = arr[j];
                    index = j;
                }
            }
            temp = arr[i];
            arr[i] = max;
            arr[index] = temp;
        }

        System.out.print("第 " + k + " 大的数：" + arr[k - 1]);
    }

}
