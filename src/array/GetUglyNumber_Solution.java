package array;

/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
// 2020.2.9
// 2020.2.20
// 2020.7.23
public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] num = new int[index];
        num[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {
            num[i] = Math.min(num[p2] * 2, Math.min(num[p3] * 3, num[p5] * 5));
            if (num[i] == num[p2] * 2)
                p2++;
            if (num[i] == num[p3] * 3)
                p3++;
            if (num[i] == num[p5] * 5)
                p5++;
        }
        return num[index - 1];
    }
}
