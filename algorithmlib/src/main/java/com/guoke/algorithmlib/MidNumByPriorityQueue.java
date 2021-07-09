package com.guoke.algorithmlib;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.Stack;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MidNumByPriorityQueue {


    Queue<Integer> queue = new LinkedList<>();
    ArrayList<Integer> arrayList;
    LinkedList<Integer> linkedList;
    Stack<Integer> stack;
    LinkedHashMap<Integer,Object> linkedHashMap;



    // ---

    int count = 0;

    // PriorityQueue类在Java1.5中引入。
    // PriorityQueue是基于优先堆的一个无界队列，
    // 这个优先队列中的元素可以默认自然排序或者通过提供的Comparator（比较器）在队列实例化的时排序。
    // PriorityQueue 的参考：https://baijiahao.baidu.com/s?id=1665383380422326763&wfr=spider&for=pc

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    /**
     * 往一个集合插入数值，每次操作后，都返回该集合都中间值
     * 若集合为 size 偶数，返回偏小都那个
     * @param num
     *
     * 思路解析：
     * 当前目的：不停的输入数字到序列中，每次输入数字后，都能拿到按生序排列的中间数（或偏小一位）
     *
     * 实现思路：用两个队列 minQ，maxQ 存放输入的数字；
     * 当达到：
     * 条件一：minQ 的元素数量 = maxQ 的元素数量（或 + 1）
     * 条件二：当 minQ 的最小值 > maxQ 的最大值
     * 结果：那么 maxQ 的最大值就是整个序列的中间数
     *
     * 实现步骤：
     * 轮流把输入的数字，放到 minQ，maxQ，保证条件一；
     * 放入 maxQ 之前，先放入 minQ 再取最小值出来放入 maxQ，这样保证 minQ 的所有元素都大于 maxQ；
     * 同理，
     * 放入 minQ 之前，先放入 maxQ 再取最大值出来放入 minQ，这样保证 maxQ 的所有元素都小于 minQ；如此保证条件二；
     * 所以能达到预期的结果。
     */
    public void Insert(Integer num) {
        if (count % 2 == 0) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        count++;
        System.out.println(MidNumByPriorityQueue.GetMedian());
    }
    public static int GetMedian() {
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        MidNumByPriorityQueue t = new MidNumByPriorityQueue();
        t.Insert(1);
        t.Insert(2);
        t.Insert(0);
        t.Insert(20);
        t.Insert(10);
        t.Insert(22);
    }
}

