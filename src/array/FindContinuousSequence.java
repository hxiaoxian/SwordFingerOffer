package array;

import java.util.ArrayList;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * <p>
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    // 双指针
    // 2020.2.8
    // 2020.2.20
    // 2020.7.23
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1;
        int high = 2;
        int mid = (sum + 1) >> 1;
        int current = low + high;
        while (low < mid) {
            while (current < sum) {
                high++;
                current += high;
            }
            if (current == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++)
                    list.add(i);
                result.add(list);
            }
            current -= low;
            low++;
        }
        return result;
    }
}
