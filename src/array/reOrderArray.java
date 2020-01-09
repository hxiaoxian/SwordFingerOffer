package array;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
// 空间复杂度O（N）
// 时间复杂度O（N）
public class reOrderArray {
    public void reOrderArray(int[] array) {
        int[] even = new int[array.length];
        int indexOdd = 0;
        int indexEven = 0;
        for (int num : array) {
            if ((num & 0x1) == 1)
                array[indexOdd++] = num;
            else
                even[indexEven++] = num;
        }
        for (int i = 0; i < indexEven; i++) {
            array[indexOdd + i] = even[i];
        }
    }
}
