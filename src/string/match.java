package string;

/**
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
//  1.若当前字符存在下一个字符，看下一个字符是否是 '*'，如果是，有2种情况
//     *      一：当前匹配
//     *      1.1match(str,i + 1,pattern,j)//跳过str
//     *      1.2match(str,i,pattern,j + 2)//跳过pattern
//     *      1.3match(str,i + 1,pattern,j + 2)//这一种可以省略，相当于 1.1 + 1.2
//     *      二：当前不匹配
//     *      match(str,i,pattern,j + 2)//跳过pattern
//     * 2.下一个不是 *
//     *     当前匹配 return match(str,i + 1,pattern,j + 1)
// 2020.7.24
public class match {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return help(str, 0, pattern, 0);
    }

    private boolean help(char[] str, int i, char[] pattern, int j) {
        if (j == pattern.length)
            return i == str.length;
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            if (str.length != i && (str[i] == pattern[j] || pattern[j] == '.'))
                return help(str, i + 1, pattern, j) || help(str, i, pattern, j + 2);
            else
                return help(str, i, pattern, j + 2);
        }
        if (str.length != i && (str[i] == pattern[j] || pattern[j] == '.')) {
            return help(str, i + 1, pattern, j + 1);
        }
        return false;
    }
}
