package string;

import java.util.Stack;

/**
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
// 2020.2.20
public class ReverseSentence {

    public static String ByStack(String str) {
        if (str == null || str.length() == 0 || str.trim().equals(""))
            return str;
        String[] strs = str.split("\\.");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String s : strs)
            stack.push(s);
        while (!stack.isEmpty())
            sb.append(stack.pop() + ".");
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static void main(String[] args) {
        System.out.println(ByStack("www.baidu.com"));
    }


    // 两次反转,首先反转字符串，再依次反转各个单词
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0 || str.trim().equals(""))
            return str;
        char[] c = str.toCharArray();
        reverse(c, 0, str.length() - 1);
        int begin = 0;
        int end = 0;
        while (begin != str.length() - 1) {
            if (c[begin] == ' ') {
                begin++;
                end++;
            } else if (c[end] == ' ') {
                reverse(c, begin, end - 1);
                begin = end;
            } else if (end == str.length() - 1) {
                reverse(c, begin, end);
                begin = end;
            } else
                end++;
        }
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

    // 利用栈
    public String ReverseSentence1(String str) {
        if (str == null || str.length() == 0 || str.trim().equals(""))
            return str;
        String[] strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String s : strings) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        // 去除最后一个空格位
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}
