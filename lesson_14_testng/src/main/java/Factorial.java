public class Factorial {
    public int calculate(int n) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (n == 1 || n == 2)
            return n;
        else
            return calculate(n - 1) * n;
    }
}
