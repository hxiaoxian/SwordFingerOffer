package array;

/**
 * 题目描述：不修改数组找出重复的数字
 * 在一个长度为n+1的数组里的所有数字都在1-n的范围内，所以数组中至少有一个是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字是2或者3
 */
// 时间复杂度：O（NlogN）
// 空间复杂度：O（1）
// 利用二分思想
public class getDuplication {
    public int getDuplication(int[] arr, int length) {
        int left = 1;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int count = cal(arr, length, left, mid);
            if (count == left) {
                if (count > 1)
                    return left;
                else
                    break;
            }
            if (count > mid - left + 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int cal(int[] arr, int length, int start, int end) {
        if (arr == null)
            return 0;
        int count = 0;
        for (int num : arr) {
            if (num >= start && num <= end) {
                count++;
            }
        }
        return count;
    }
}
