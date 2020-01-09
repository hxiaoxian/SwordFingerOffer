package array;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    // 依次异或数组中的每个数字，得到的结果就是两个只出现一次的数字的异或结果
    // 在这个结果数字的二进制表示中至少有一位为1，通过这个位，将原数组分隔为两个子数组，分别求出两个只出现一次的数字
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xor1 = 0;
        for (int num : array)
            xor1 ^= num;
        int index = 1;
        while ((index & xor1) == 0)
            index <<= 1;
        int result1 = 0;
        int result2 = 0;
        for (int num : array) {
            if ((index & num) == 0) {
                result1 ^= num;
            } else {
                result2 ^= num;
            }
        }
        num1[0] = result1;
        num2[0] = result2;
    }
}
