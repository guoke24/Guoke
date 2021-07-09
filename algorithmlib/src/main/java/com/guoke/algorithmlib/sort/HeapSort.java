package com.guoke.algorithmlib.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 其实就是多次的父子点交换
 */
public class HeapSort {

    public static void main(String []args){
        int []arr = {11,7,18,3,5,4,10,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int []arr){
        // 1.构建根节点的大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }

        // 2.调整堆结构 + 交换堆顶元素与末尾元素
        for(int j= arr.length - 1; j > 0; j--){

            swap(arr,0,j);
            // 将堆顶元素与末尾元素进行交换，其实就是将整个数组的最大值放到末尾

            adjustHeap(arr,0, j);
            // 重新对堆进行根节点的大顶堆调整，不过这次调整不包括上一个末尾元素，
            // 上一步的交换操作，已经把最大值放到最末尾，
            // 此次的大顶堆调整，将排除末尾节点，得到一个新的二叉树然后进行大顶堆调整，
            // 排除末尾节点的具体操作，就是每次调用 adjustHeap 方法，arr 的长度都比上一次少 1。
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * 调整出以 i 当作根节点的大顶堆
     * 具体做法是：从它所有的子节点中（包括直接直接子节点和间接子节点），寻找最大值来替代它
     *
     * 该算法成立的前提是，i 的所有子树都是大顶堆；
     * 当你从第一个非叶子结点从下至上，从右至左调整结构，那么每一次执行该算法的前提条件都成立。，
     *
     * @param arr
     * @param i 把 i 当作根节点
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){

        int temp = arr[i];//先取出当前元素i

        //从 i 结点的左子结点开始，也就是 2i+1 处开始
        for(int k = i * 2 + 1 ; k < length ; k = k * 2 + 1){

            //如果左子结点小于右子结点，k 指向右子结点
            if(k + 1 < length && arr[k] < arr[k+1]){
                k++;
            }

            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] >temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }

        arr[i] = temp; // 将 temp 值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
//————————————————
//        版权声明：本文为CSDN博主「爱上猫de鱼」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/boy_chen93/article/details/84835052
