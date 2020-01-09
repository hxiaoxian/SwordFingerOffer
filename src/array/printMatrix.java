package array;

import java.util.ArrayList;

/**
 *题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *              则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
//
//向右走存入整行的值，当存入后，该行再也不会被遍历，代表上边界的 up 加一，同时判断是否和代表下边界的 down 交错
//向下走存入整列的值，当存入后，该列再也不会被遍历，代表右边界的 right 减一，同时判断是否和代表左边界的 left 交错
//向左走存入整行的值，当存入后，该行再也不会被遍历，代表下边界的 down 减一，同时判断是否和代表上边界的 up 交错
//向上走存入整列的值，当存入后，该列再也不会被遍历，代表左边界的 left 加一，同时判断是否和代表右边界的 right 交错
public class printMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++)
                list.add(matrix[up][i]);
            up++;
            if (up > down)
                break;
            for (int i = up; i <= down; i++)
                list.add(matrix[i][right]);
            right--;
            if (left > right)
                break;
            for (int i = right; i >= left; i--)
                list.add(matrix[down][i]);
            down--;
            if (up > down)
                break;
            for (int i = down; i >= up; i--)
                list.add(matrix[i][left]);
            left++;
            if (left > right)
                break;
        }
        return list;
    }
}
