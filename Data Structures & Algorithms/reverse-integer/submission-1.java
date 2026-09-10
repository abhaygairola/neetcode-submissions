class Solution {
    public int reverse(int x) {
        int imax = Integer.MAX_VALUE;
        int imin = Integer.MIN_VALUE;

        int res = 0;
        while (x !=0) {
            int last = x % 10;
            if (imax / 10 < res || (imax / 10 == res && last > imax % 10)) {
                return 0;
            }
            if (imin / 10 > res || (imax / 10 == res && last < imin % 10)) {
                return 0;
            }
            res = (res * 10) + (x % 10);
            x = x / 10;
        }
        return res;
    }
}
