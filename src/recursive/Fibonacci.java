package recursive;

/**
 *
 */
// 2020.2.20
public class Fibonacci {
    public int Fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
