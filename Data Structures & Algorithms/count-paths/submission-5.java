class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[0] = 1;
                    continue;
                }
                int down = (j - 1 >= 0) ? temp[j - 1] : 0;
                int right = (i - 1 >= 0) ? prev[j] : 0;
                temp[j] = down + right;
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}
