class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minNow = prices[0];

        for (int price : prices) {
            maxP = Math.max(maxP, price - minNow);
            minNow = Math.min(minNow, price);
        }

        return maxP;
    }
}
