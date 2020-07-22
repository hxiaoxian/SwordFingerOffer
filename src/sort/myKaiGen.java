package sort;

/**
 *
 */
public class myKaiGen {

    public static double mySqrt(int n) {
        double l = 0, r = n / 2 + 1;
        double e = 1e-15;
        double mid = (l + r) / 2.0;
        while (mid * mid > n + e || mid * mid < n - e) {
            mid = (l + r) / 2.0;
            if (mid * mid > n)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(myKaiGen.mySqrt(6));
    }
}
