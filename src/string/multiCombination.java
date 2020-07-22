package string;

import java.util.ArrayList;

/**
 * 题目
 * 求字符的所有组合，例如输入三个字符a、b、c，其组合有a、b、c、ab、ac、bc以及abc。
 * 值得注意的是ab和ba虽然是两种排列，但是只算作一种组合
 * <p>
 * <p>
 * <p>
 * 解题思路
 * 在n个字符中选择m的组合时，可以将原问题拆分为两个子问题：
 * 1）如果组合里包含第一个字符，则在剩下的n-1个中选择m-1个字符；
 * 2）如果组合里不包含第一个字符，则在剩下的n-1个中选择m个字符；
 */
// 2020.2.20
public class multiCombination {
    ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> multiCombination(String str) {
        if (null == str || str.length() == 0) {
            return result;
        }
        int iter = 1;
        while (iter <= str.length()) {
            multiCombination(str, iter, new StringBuilder());
            ++iter;
        }
        return result;
    }

    // substring可能效率不高，可增加begin索引位，同时把字符串转换为char数组
    private void multiCombination(String str, int m, StringBuilder sb) {
        if (m == 0) {
            result.add(new String(sb));
            return;
        }
        if (str.length() != 0) {
            sb.append(str.charAt(0));
            // 从剩余的n-1个中选择m-1个
            multiCombination(str.substring(1), m - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            // 从剩余的n-1个中选择m个
            multiCombination(str.substring(1), m, sb);
        }
    }
}
