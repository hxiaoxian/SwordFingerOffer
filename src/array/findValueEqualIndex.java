package array;

/**
 * 题目：数组中数值和下标相等的元素
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 * 例如，在数组{-3, -1, 1, 3, 5}中，数字3和它的下标相等。
 * <p>
 * 主要思路：数组是递增有序的，使用二分查找。
 * <p>
 * 先获取数组的中间数，若中间数的值和下标相等，则找到一个满足条件的数；
 * 若中间数的值大于它的下标，则根据数组递增的特性可知：中间数以后的元素的值至少每个比前面大1，
 * 同时它们的下标每次也是增加1，从而右边的这些元素的值都大于它们的下标，因此需要继续在左边寻找。
 * <p>
 * 同理，若中间数的值小于它的下标，则中间数左边的那些元素的值也都小于它们的下标，因此需要继续在右边寻找。
 */
// 2020.2.9
// 2020.2.20
public class findValueEqualIndex {
    private static int findValueEqualIndex(int[] data) {
        if (data == null)
            return -1;
        int left = 0;
        int right = data.length - 1;
        //二分查找的变形
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (data[mid] == mid)
                return mid;
            else if (data[mid] > mid)
                right = mid - 1; //在左边查找
            else if (data[mid] < mid)
                left = mid + 1;  //在右边查找
        }
        return -1;
    }
}
