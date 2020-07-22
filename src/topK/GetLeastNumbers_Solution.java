package topK;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
// 2020.2.11
// 2020.2.20
public class GetLeastNumbers_Solution {
    // partition思想，O（N）
    // 如果基于数组的第k个数字来调整，则使得比第k个数字小的所有数字都位于数组的左边，比第k个数字大的所有数字都位于数组的右边。
    // 这样调整之后，位于数组中左边的k个数字就是最小的k个数字
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || k <= 0 || k > input.length)
            return new ArrayList<>();
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private int partition(int[] input, int start, int end) {
        int low = start;
        int high = end;
        int key = input[low];
        while (low < high) {
            while (low < high && key <= input[high])
                high--;
            input[low] = input[high];
            while (low < high && key >= input[low])
                low++;
            input[high] = input[low];
        }
        input[low] = key;
        return low;
    }

    // 最大堆，O（NlogK）
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        if (input == null || k <= 0 || k > input.length)
            return new ArrayList<>();
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : input) {
            if (bigHeap.size() < k) {
                bigHeap.offer(num);
            } else {
                if (num < bigHeap.peek()) {
                    bigHeap.poll();
                    bigHeap.offer(num);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!bigHeap.isEmpty()) {
            result.add(bigHeap.poll());
        }
        return result;
    }
}
