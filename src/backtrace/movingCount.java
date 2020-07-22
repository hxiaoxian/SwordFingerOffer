package backtrace;

/**
 *题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？w
 */
// 2020.2.20
public class movingCount {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[] flag = new boolean[rows * cols];
        return help(threshold, rows, cols, 0, 0, flag);
    }

    private int help(int threshold, int rows, int cols, int i, int j, boolean[] flag) {
        int count = 0;
        int index = i * cols + j;
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[index] == true || getSum(i) + getSum(j) > threshold) {
            return 0;
        }
        flag[index] = true;
        count += 1 + help(threshold, rows, cols, i + 1, j, flag) +
                help(threshold, rows, cols, i - 1, j, flag) +
                help(threshold, rows, cols, i, j - 1, flag) +
                help(threshold, rows, cols, i, j + 1, flag);
        return count;
    }

    private int getSum(int num) {
        int count = 0;
        while (num > 0) {
            count += num % 10;
            num /= 10;
        }
        return count;
    }
}
