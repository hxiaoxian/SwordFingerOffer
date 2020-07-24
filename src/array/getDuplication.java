package array;

/**
 * 题目描述：不修改数组找出重复的数字
 * 在一个长度为n+1的数组里的所有数字都在1-n的范围内，所以数组中至少有一个是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字是2或者3
 *
 * 数组长度为n+1，而数字只从1到n，说明必定有重复数字。
 * 可以由二分查找法拓展：
 * 把1~n的数字从中间数字m分成两部分，若前一半1~m的数字数目超过m个，说明重复数字在前一半区间，
 * 否则，在后半区间m+1~n。每次在区间中都一分为二，知道找到重复数字。
 */
// 时间复杂度：O（NlogN）
// 空间复杂度：O（1）
// 利用二分思想
// 2020.2.9
// 2020.2.20
// 2020.7.23
public class getDuplication {
    public int getDuplication(int[] arr, int length) {
        int left = 1;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = cal(arr, left, mid);
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

    private int cal(int[] arr, int start, int end) {
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
