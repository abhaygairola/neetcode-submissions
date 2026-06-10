class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[] prev = new int[n];


        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    temp[j] = (i <= 0 || j <= 0) ? 1 : 1 + prev[j - 1];
                } else {
                    temp[j] = Math.max((i <= 0) ? 0 : prev[j], (j <= 0) ? 0 : temp[j - 1]);
                }
            }
            prev=temp;
        }

        return prev[n - 1];
    }
}
