package queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3
 * 那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}
 * {2,[3,4,2],6,2,5,1}
 * {2,3,[4,2,6],2,5,1}
 * {2,3,4,[2,6,2],5,1}
 * {2,3,4,2,[6,2,5],1}
 * {2,3,4,2,6,[2,5,1]}。
 */
// 2020.2.20
// 2020.7.24
public class maxInWindows {
    // 滑动窗口的最大值总是保存在队列首部，队列里面的数据总是从大到小排列。
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length < size || num == null || num.length == 0 || size <= 0)
            return result;
        // 队列保存元素下标
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] > num[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            // 去除过期元素
            if (queue.peekFirst() == i - size) {
                queue.pollFirst();
            }
            if (i >= size - 1) {
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;
    }

    // leetcode 239
    // ArrayList<Integer> 转 int[]  、 Integer[]
    //list.stream().mapToInt(Integer::intValue).toArray() 转 int[]
    //list.toArray(new Integer[list.size()]); 转 Integer[]
    public int[] maxSlidingWindow(int[] num, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length < k || num == null || num.length == 0 || k <= 0)
            return new int[]{};
        // 队列保存元素下标
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] > num[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            // 去除过期元素
            if (queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                result.add(num[queue.peekFirst()]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
