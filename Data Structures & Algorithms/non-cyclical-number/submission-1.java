class Solution {
    public boolean isHappy(int n) {
        int fast=sumHappy(n), slow=n;

        while (fast != slow) {
            fast= sumHappy(fast);
            fast = sumHappy(fast);
            slow = sumHappy(slow);
            if(fast==1)return true;
        }
        return fast==1;
    }

    private int sumHappy(int n) {
        int res=0;
        while (n != 0) {
            int d = n % 10;
            res += (d * d);
            n /= 10;
        }
        return res;
    }
}
