package string;

/**
 * 输入数字n，按顺序打印从1到最大的n位十进制数。
 * 比如输入3，则打印1、2/3一直到最大的3位数999
 */
public class printToMaxOfDigits {
    // 利用字符串存储大数
    public void printToMaxOfDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n + 1];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        while (!incre(number)) {
            print(number);
        }
    }

    private boolean incre(char[] number) {
        boolean overflow = false;
        int up = 0;
        for (int i = number.length - 1; i >= 0; i--) {
            int num = number[i] - '0' + up;
            if (i == number.length - 1)
                num++;
            if (num >= 10) {
                if (i == 0)
                    overflow = true;
                else {
                    num -= 10;
                    up = 1;
                    number[i] = (char) (num + '0');
                }
            } else {
                number[i] = (char) (num + '0');
                break;
            }
        }
        return overflow;
    }

    private void print(char[] number) {
        boolean flag = true;
        for (int i = 0; i < number.length; i++) {
            if (flag && number[i] != '0') {
                flag = false;
            }
            if (!flag) {
                System.out.println(number[i]);
            }
        }
    }

    // 全排列
    public void printToMaxOfDigits1(int n) {
        char[] number = new char[n + 1];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    private void printToMaxOfNDigitsRecursively(char[] number, int n, int k) {
        if (k == n) {
            print(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[k + 1] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, k + 1);
        }
    }
}
