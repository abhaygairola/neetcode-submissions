class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n1 + n2 != n3)
            return false;

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        dp[n1][n2] = true;

        for (int i1 = n1; i1 >= 0; i1--) {
            for (int i2 = n2; i2 >= 0; i2--) {

                if (i1 == n1 && i2 == n2)
                    continue;

                int k = i1 + i2;

                boolean take1 = false;
                boolean take2 = false;

                if (i1 < n1 &&
                    s1.charAt(i1) == s3.charAt(k)) {
                    take1 = dp[i1 + 1][i2];
                }

                if (i2 < n2 &&
                    s2.charAt(i2) == s3.charAt(k)) {
                    take2 = dp[i1][i2 + 1];
                }

                dp[i1][i2] = take1 || take2;
            }
        }

        return dp[0][0];
    }
}