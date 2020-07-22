package bit;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 保证base和exponent不同时为0
 */
// 2020.2.20
public class Power {
    // 递归分治
    public double Power1(double base, int exponent) {
        boolean falg = exponent < 0;
        if (falg)
            exponent = -exponent;
        double result = getPower(base, exponent);
        return falg ? 1 / result : result;
    }

    private double getPower(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double result = getPower(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1)
            result *= base;
        return result;
    }

    //快速幂
    public double Power(double base, int exponent) {
        boolean flag = exponent < 0;
        if (flag)
            exponent = -exponent;
        double result = 1;
        while (exponent > 0) {
            if ((exponent & 0x1) == 1)
                result *= base;
            exponent >>= 1;
            base *= base;
        }
        return flag ? 1 / result : result;
    }
}
