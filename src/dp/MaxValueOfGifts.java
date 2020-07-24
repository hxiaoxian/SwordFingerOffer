package dp;

/**
 * 　在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */
// 2020.2.20
// 2020.7.24
public class MaxValueOfGifts {
    //按列优化后的一维dp(该数组前面j个数字分别是当前第i列前面j个格子礼物的最大价值)
    public static int maxValueOfGiftsByRow(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0)
            return 0;
        int row = values.length;
        int col = values[0].length;
        int[] dp = new int[row + 1];
        for (int i = 1; i <= col; i++) {
            for (int j = 1; j <= row; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j]) + values[j - 1][i - 1];
            }
        }
        return dp[row];
    }

    //按行优化后的一维dp(该数组前面j个数字分别是当前第i行前面j个格子礼物的最大价值)
    public static int maxValueOfGiftsByCol(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0)
            return 0;
        int row = values.length;
        int col = values[0].length;
        int[] dp = new int[col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j]) + values[i - 1][j - 1];
            }
        }
        return dp[col];
    }

    //二维dp
    public static int maxValueOfGifts(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0)
            return 0;
        int row = values.length;
        int col = values[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + values[i - 1][j - 1];
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        System.out.println(maxValueOfGifts(new int[][]{{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}}));
    }
}
