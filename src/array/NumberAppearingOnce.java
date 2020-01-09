package array;

/**
 * 题目
 * 　　在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * <p>
 * 思路
 * 　　这道题中数字出现了三次，无法像 数组中只出现一次的两个数字一样通过利用异或位运算进行消除相同个数字。
 * 但是仍然可以沿用位运算的思路。
 * <p>
 * 　　将所有数字的二进制表示的对应位都加起来，如果某一位能被三整除，那么只出现一次的数字在该位为0；反之，为1。
 */
public class NumberAppearingOnce {
    public static int findNumberAppearingOnce(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int[] bit = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int mask = 1;
            for (int j = 31; j >= 0; j--) {
                int count = arr[i] & mask;
                if (count != 0)
                    bit[i]++;
                mask <<= 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += bit[i] % 3;
            result <<= 1;
        }
        return result;
    }
}
