package string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * <p>
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0 || str == null)
            return result;
        help(result, 0, str.toCharArray());
        Collections.sort(result);
        return result;
    }

    private void help(ArrayList<String> result, int index, char[] c) {
        if (index == c.length)
            result.add(new String(c));
        for (int i = index; i < c.length; i++) {
            if (i == index || c[i] != c[index]) {
                swap(c, i, index);
                help(result, index + 1, c);
                swap(c, i, index);
            }
        }
    }

    private void swap(char[] t, int i, int j) {
        char temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }
}

/*
    //无字符重复情况
    static ArrayList<String> result = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return result;
        backtrace(str, new StringBuilder());
        Collections.sort(result);
        return result;
    }

    private static  void backtrace(String str, StringBuilder sb) {
        if (sb.length() == str.length()) {
            result.add(new String(sb));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (sb.toString().indexOf(str.charAt(i)) != -1)
                continue;
            sb.append(str.charAt(i));
            backtrace(str, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    */

