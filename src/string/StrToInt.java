package string;

/**
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * <p>
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * <p>
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
// 2020.2.20
public class StrToInt {
    public int StrToInt(String str) {
        if (str.equals("-2147483649") || str.equals("2147483648"))
            return 0;
        str = str.trim();
        if (str == null || str.length() == 0 || str.equals(""))
            return 0;
        int flag = 1;
        long result = 0;
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = -1;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        for (int j = str.length(); i < j; i++) {
            char c = str.charAt(i);
            if (c > 57 || c < 48)
                return 0;
            result = result * 10 + c - '0';
            if (flag == 1 && result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (flag == -1 && result > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) result * flag;
    }
}
