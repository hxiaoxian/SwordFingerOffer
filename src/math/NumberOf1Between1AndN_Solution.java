package math;

/**
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN_Solution {
    //  牛客大佬解法
    //  复杂度O(logn)
    //   举例 例如：31256 求百位数字为1的个数，那么需要分开讨论，
    //            用a=31256/100=312  b=31256%100=56
    //            （1）百位=0；那么就是(a/10)*100
    //            （2）如果百位为1，那么就是(a/10)*100+(b+1)
    //            （3）如果百位为>1 ,那么 就是 (a/10+1)*100
    //  所以将数字n从个位开始一直取到最大位位置。
    public int NumberOf1Between1AndN_Solution(int n) {
        int ones = 0;
        for (int m = 1; m <= n; m *= 10) {
            int num = n / m % 10;
            int a = n / m;
            int b = n % m;
            if (num > 1) {
                ones += (a / 10 + 1) * m;
            } else if (num == 1) {
                ones += a / 10 * m + b + 1;
            } else {
                ones += (a / 10) * m;
            }
        }
        return ones;
    }

    // 遍历每一个数，累加1的个数
    public int NumberOf1Between1AndN_Solution1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += help(i);
        }
        return count;
    }

    private int help(int i) {
        int count = 0;
        while (i > 0) {
            if (i % 10 == 1)
                count++;
            i /= 10;
        }
        return count;
    }
}
