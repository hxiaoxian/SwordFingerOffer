package string;

/**
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

//  12e说明e的后面必须有数字，不能有两个e
//  +-5说明符号位要么出现一次在首位，要么出现一次在e的后一位，其他地方都不能有
//  12e4.3说明e的后面不能有小数，1.2.3说明不能有两个小数点
//  1a3.14说明不能有其他的非法字符，比如这里的a
public class isNumeric {
    public boolean isNumeric(char[] str) {
        boolean fuhao = false, hasE = false, decimal = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E' || str[i] == 'e') {
                if (i == str.length - 1)
                    return false;
                if (hasE)
                    return false;
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if (!fuhao && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false;
                if (fuhao && str[i - 1] != 'E' && str[i - 1] != 'e')
                    return false;
                fuhao = true;
            } else if (str[i] == '.') {
                if (hasE)
                    return false;
                if (decimal)
                    return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9')
                return false;
        }
        return true;
    }
}

