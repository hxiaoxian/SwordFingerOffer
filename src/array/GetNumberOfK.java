package array;

/**
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */
// 2020.2.9
// 2020.2.20
// 2020.7.23
public class GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0 || array == null)
            return 0;
        int left = left(array, k);
        int right = right(array, k);
        return (left == -1 || right == -1) ? 0 : right - left + 1;
    }

    private int left(int[] array, int k) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (array[mid] == k) {
                right = mid;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == array.length)
            return -1;
        return array[left] == k ? left : -1;
    }

    private int right(int[] array, int k) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (array[mid] == k) {
                left = mid + 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == 0)
            return -1;
        return array[left - 1] == k ? left - 1 : -1;
    }

}
