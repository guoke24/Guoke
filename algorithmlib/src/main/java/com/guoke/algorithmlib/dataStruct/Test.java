package com.guoke.algorithmlib.dataStruct;

import android.os.Handler;
import android.os.Message;
import android.util.ArrayMap;
import android.util.SparseArray;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    LinkedBlockingQueue linkedBlockingQueue;
    PriorityBlockingQueue priorityBlockingQueue;
    DelayQueue delayQueue;
    SynchronousQueue synchronousQueue;
    static HashMap<Integer,Integer> hashMap;

    android.util.LruCache<Integer,Integer> integerLruCache;
    androidx.collection.LruCache<Integer,Integer> integerLruCache2;
    LinkedHashMap linkedHashMap;
    SparseArray<String> sparseArray;
    ArrayMap<Integer,String> arrayMap;
    Handler handler;
    ThreadPoolExecutor threadPoolExecutor;

    public static void main(String[] args){
        Message.obtain();
    }

    private static void testbinarySearch(){
        int[] arr = new int[8];
        int[] arr1 = {1,3,5,7};

        int index1 = binarySearch(arr1,1,-1);
        int index2 = binarySearch(arr1,4,2);
        System.out.println(index1);
        System.out.println(index2);

        System.out.println("非运算");
        index1 = ~index1;
        index2 = ~index2;
        System.out.println(index1);
        System.out.println(index2);

//        System.out.println("再非运算");
//        index1 = ~index1;
//        index2 = ~index2;
//        System.out.println(index1);
//        System.out.println(index2);
    }

    /**
     *
     * @return 返回的数，正数为匹配的 index；
     * 负数为适合的插入位置的 index 再进行非运算后的数，为了区别匹配的 index 才做非运算的，再做一次便可得到原值；
     * 精妙之处在此。
     */
    static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1; // 等价于 '/2'（同样省略小数位的值）
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }


}
