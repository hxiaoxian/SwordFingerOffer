package array;


/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * <p>
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * <p>
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 */
public class InversePairs {

    // O(NlogN)  归并排序
    // 先把数组分隔成子数组，统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之前的逆序对的数目。
    // 在统计逆序对的过程中，还需要对数组进行排序（辅助空间）
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return inverse(array, copy, 0, array.length - 1);
    }

    private int inverse(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) >> 1;
        int left = inverse(copy, array, start, mid);
        int right = inverse(copy, array, mid + 1, end);
        int leftIndex = mid, rightIndex = end, copyIndex = end, count = 0;
        while (leftIndex >= start && rightIndex > mid) {
            if (array[leftIndex] > array[rightIndex]) {
                copy[copyIndex--] = array[leftIndex--];
                count += rightIndex - mid;
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[copyIndex--] = array[rightIndex--];
            }
        }
        while (leftIndex >= start) {
            copy[copyIndex--] = array[leftIndex--];
        }
        while (rightIndex > mid) {
            copy[copyIndex--] = array[rightIndex--];
        }
        return (left + right + count) % 1000000007;
    }


    // 暴力 O(N^2)
    public static int InversePairs1(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count % 1000000007;
    }
}
