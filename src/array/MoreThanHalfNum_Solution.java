package array;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

// 时间复杂度O（N)
// 不修改数组
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                count = 1;
                result = array[i];
            } else if (array[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        int num = 0;//需要判断是否真的是大于半数
        for (int i = 0; i < array.length; i++)
            if (array[i] == result)
                num++;
        return (num > array.length / 2) ? result : 0;
    }
}
