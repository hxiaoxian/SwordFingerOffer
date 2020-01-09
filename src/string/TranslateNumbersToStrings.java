package string;

/**
 * 题目
 * 　　给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0翻译成"a"，1翻译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。
 * 例如12258有5种不同的翻译，它们分别"bccfi", "bwfi", "bczi", "mcfi" 和"mzi" 。
 * <p>
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * * ————————————————
 * 思路：利用递归的思想分析，用动态规划自下而上求解（从右到左）
 * <p>
 * 当最开始的一个或者两个数字被翻译成一个字符后，我们接着翻译后面剩下的数字；
 * 用一个递归式来表示：定义f(i)表示从第i位数字开始的不同翻译的数目，那么f(i) = f(i+1) + g(i,i+1)*f(i+2)；
 * 当第i位和第i+1位两位数字拼接起来的数字在10~25的范围内时，函数g(i,i+1)的值为1，否则为0。
 * 该问题使用上面的递归方法会存在很多重复子问题。所以我们使用动态规划的方法，自低向上求解问题，消除重复子问题。
 * ————————————————
 */
public class TranslateNumbersToStrings {
    public int getTranslationCount(int number) {
        if (number <= 0)
            return 0;
        if (number == 1)
            return 1;
        return help(Integer.toString(number));
    }

    private int help(String str) {
        int f1 = 1;
        int f2 = 1;
        int g;
        for (int i = str.length() - 2; i >= 0; i--) {
            if (Integer.parseInt(str.charAt(i) + "" + str.charAt(i + 1)) < 26)
                g = 1;
            else
                g = 0;
            int temp = f2;
            f2 = f2 + g * f1;
            f1 = temp;
        }
        return f2;
    }
}
