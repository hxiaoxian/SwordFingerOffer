package string;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
// 2020.2.20
public class LeftRotateString {
    //类同翻转数组，翻转字符串3次
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0 || str.equals(""))
            return "";
        int length = str.length() - 1;
        char[] c = str.toCharArray();
        reverse(c, 0, n - 1);
        reverse(c, n, length);
        reverse(c, 0, length);
        return new String(c);
    }

    private void reverse(char[] c, int left, int right) {
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
    }
}
