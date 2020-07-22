package dp;

/**
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
// 动态规划特点：1 求一个问题的最优解
//              2 整体问题的最优解是依赖各个子问题的最优解
//              3 大问题分解为多个小问题，小问题之间有相互重叠的更小的子问题
//              4 从上往下分析问题 从下往上解决问题

//   为了避免重复求解子问题，可以用从下往上的顺序先计算小问题的最优解并存储下来，再以此为基础求取大问题的最优解
// 2020.2.20
public class cutRope {
    //dp
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++)
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
        }
        return dp[n];
    }

    // 贪心
    public int cutRope2(int target) {
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;
        int count3 = target / 3;
        if (target - count3 * 3 == 1)
            count3 -= 1;
        int count2 = (target - count3 * 3) / 2;
        return (int) Math.pow(3, count3) * (int) Math.pow(2, count2);
    }
}
