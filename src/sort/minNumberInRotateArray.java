package sort;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 如果数组元素允许重复，会出现一个特殊的情况：nums[l] == nums[m] == nums[h]，
 * 此时无法确定解在哪个区间，需要切换到顺序查找。
 * 例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间。
 */
// 2020.2.20
// 2020.7.24
public class minNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        int l = 0;
        int h = array.length - 1;
        while (l < h) {
            int m = (l + h) >>> 1;
            // 三个值都相同则进行顺序查找
            if (array[l] == array[m] && array[m] == array[h])
                return help(array, l, h);
            if (array[m] <= array[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return array[l];
    }

    private int help(int[] array, int left, int right) {
        int result = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < result)
                result = array[i];
        }
        return result;
    }
}

