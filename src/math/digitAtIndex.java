package math;

/**
 * 题目：数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一个函数求任意位对应的数字。
 * <p>
 * 主要思路：
 * 举例分析，比如找第1001位数字，
 * 1）1位数的数值有10个：0~9，数字为10×1=10个，显然1001>10，跳过这10个数值，在后面找第991（1001-10）位数字。
 * 2）2位数的数值有90个：10~99，数字为90×2=180个，且991>180，继续在后面找第811（991-180）位数字。
 * 3）3位数的数值有900个：100~999，数字为900×3=2700个，且811<2700
 * 说明第811位数字在位数为3的数值中。由于811=270×3+1，所以第811位是从100开始的第270个数值即370的第二个数字，就是7。
 * <p>
 * 按此规律，可求出其他数字。
 * <p>
 * 关键点：位数的数值个数
 * 时间复杂度：O(logn)，按位数进行查找
 */
public class digitAtIndex {

    public int digitAtIndex(int index) {
        if (index < 0)
            return -1;
        int digits = 1;
        while (true) {
            int numbers = countOfNum(digits);
            if (index < numbers * digits)
                return digitAtIndex(index, digits);
            //在下一位中查找
            index -= numbers * digits;
            digits++;
        }
    }

    //digits位数的数字个数，
    //两位数有9*10=90个（10~99），三位数有9*100=900个（100~999）
    private int countOfNum(int digits) {
        if (digits == 1)
            return 10;
        return 9 * (int) Math.pow(10, digits - 1);

    }

    private int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int count = digits - index % digits;
        for (int i = 1; i < count; i++) {
            number /= 10;
        }
        return number % 10;
    }

    //digits位数的第一个数字，两位数从10开始，三位数从100开始
    private int beginNumber(int digits) {
        if (digits == 1)
            return 0;
        return (int) Math.pow(10, digits - 1);
    }
}
