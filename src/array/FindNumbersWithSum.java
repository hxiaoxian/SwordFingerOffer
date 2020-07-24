package array;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
// 2020.2.9
// 2020.2.20
// 2020.7.23
public class FindNumbersWithSum {

    // 双指针 O（N） 利用数组递增的特性
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2)
            return list;
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] < sum) {
                i++;
            } else
                j--;
        }
        return list;
    }
}
