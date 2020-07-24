package string;

/**
 * 题目要求：
 * 找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流google中只读出前两个字符go时，第一个只出现一次的字符是g；当读完google时，第一个只出现一次的字符是l。
 * <p>
 * 解题思路：
 * 此题的关键在于“字符流”。
 * 因此最好能够记住在哪个位置出现了哪个字符，从而可以完成每读到一个字符，就能动态更新到目前为止第一个出现一次的字符。
 * 此题同样使用了长度为256的int数组作为哈希表，用字符的ascii码值作为表的键值。
 * 当字符仅出现了一次，就把字符的位置作为哈希表的值，如果没有出现则值为-1，如果出现的次数大于1则哈希表对应的值为-2。
 * 当想要知道到某一位置时第一个出现一次的字符，可以通过扫描该哈希表，找到大于等于0的值中的最小值，该值所对应的字符就是当前状态第一个出现一次的字符。
 */
// 2020.2.20
// 2020.7.24
public class CharStatistics {

    int[] hashtable = new int[256];
    StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        if (hashtable[ch] == 0) {
            hashtable[ch] = 1;
        } else {
            hashtable[ch] += 1;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char s : sb.toString().toCharArray()) {
            if (hashtable[s] == 1) {
                return s;
            }
        }
        return '#';
    }
}
