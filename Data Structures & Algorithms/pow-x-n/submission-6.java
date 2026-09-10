class Solution {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;

        long p = Math.abs((long)n);
        double res = 1;
        while (p > 0) {
            if ((p & 1L) == 1L) {
                res *= x;
            }
            x *= x;
            p >>= 1;
        }
        return n >= 0 ? res : 1.0 / res;
    }
}
