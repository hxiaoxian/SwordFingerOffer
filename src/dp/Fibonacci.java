package dp;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 1 1 2 3 5 8 13
 */
// 2020.2.20
// 时间复杂度O（N）
public class Fibonacci {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 2 || n == 1)
            return 1;
        int pre1 = 1, pre2 = 2;
        int result = 2;
        for (int i = 2; i < n - 1; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
