class Solution {
    public int climbStairs(int n) {
        int x[] = new int[n];
        Arrays.fill(x, -1);
        x[0] = 1;
        if(n>1)x[1] = 2;
        return calculate(n-1, x);
    }
    int calculate(int n, int x[]) {
        if (x[n] != -1)
            return x[n];
        else
            {x[n] = calculate(n - 1, x) + calculate(n - 2, x);
            return x[n];}
    }
}