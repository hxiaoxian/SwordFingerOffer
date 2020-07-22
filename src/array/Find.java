package array;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
// 从左下角或右上角出发寻找！
// 2020.2.8
// 2020.2.20
public class Find {
    public static boolean Find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0 && row > 0 && col > 0) {
            if (array[i][j] < target) {
                i++;
            } else if (array[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
