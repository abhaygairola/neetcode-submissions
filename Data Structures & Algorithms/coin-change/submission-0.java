class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int count[] = new int[amount + 1];
        int inf = amount + 10;
        Arrays.fill(count, inf);
        count[0] = 0;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j < amount + 1; j++) {
                count[j] = Math.min(count[j], count[j - coin] + 1);
            }
        }

        return count[amount] != inf ? count[amount] : -1;
    }
}
