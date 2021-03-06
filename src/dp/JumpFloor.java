package dp;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
// 2020.2.20
// 2020.7.24
public class JumpFloor {
    public int JumpFloor(int n) {
        if (n <= 2)
            return n;
        int pre1 = 1, pre2 = 2;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
