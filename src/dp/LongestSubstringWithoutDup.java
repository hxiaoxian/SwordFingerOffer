package dp;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。假设字符串中只包含从'a'到'z'的字符。
 * 思路
 * 　　动态规划法：定义函数f(i)为：以第i个字符为结尾的不含重复字符的子字符串的最大长度。
 * 　　（1）当第i个字符之前未出现过，则有：f(i)=f(i-1)+1
 * 　　（2）当第i个字符之前出现过，记该字符与上次出现的位置距离为d
 * 　　　　1）如果d<=f(i-1)，则有f(i)=d；
 * 　　　　2）如果d>f(i-1)，则有f(i)=f(i-1)+1；
 * <p>
 * <p>
 * 　　另一种思路：滑动窗口
 */
// 2020.2.20
// 2020.7.24
public class LongestSubstringWithoutDup {
    public static int maxLength(String s) {
        int i = 0, j = 0;
        int n = s.length();
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int maxLength2(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (map.containsKey(s.charAt(j)))
                i = Math.max(i, map.get(s.charAt(j)));
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
