package string;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
// 扩展：在合并两个数组（或字符串）时，如果从前往后复制每个数字（字符）则需要重复移动数字（字符）多次
//   更佳方法是从后往前复制，这样就能减少移动的次数，从而提高效率。
public class replaceSpace {
    // 双指针
    // 时间复杂度O（N）
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (char c : str.toString().toCharArray()) {
            if (c == ' ')
                count++;
        }
        int oldLength = str.length();
        int oldIndex = oldLength - 1;
        int newLength = oldLength + count * 2;
        str.setLength(newLength);
        int newIndex = newLength - 1;
        for (; oldIndex >= 0; oldIndex--) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }

    // 调库
    public String replaceSpace2(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

}
