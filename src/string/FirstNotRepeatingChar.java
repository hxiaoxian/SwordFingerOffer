package string;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * <p>
 * A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，
 * 而每个字母的index=int(word)-65，比如g=103-65=38，
 * 而数组中具体记录的内容是该字母出现的次数，最终遍历一遍字符串，
 * 找出第一个数组内容为1的字母就可以了，时间复杂度为O(n)
 */
// 2020.2.20
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int[] count = new int[58];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            count[str.charAt(i) - 'A']++;
        }
        for (int i = 0; i < length; i++) {
            if (count[str.charAt(i) - 'A'] == 1)
                return i;
        }
        return -1;
    }
}
