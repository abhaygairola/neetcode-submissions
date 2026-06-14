class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3)
            return false;
        return dfs(0, 0, s1, s2, s3);
    }

    private boolean dfs(int i1, int i2, String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (i1 == n1 && i2 == n2) {
            return true;
        }

        boolean take1 = false, take2 = false;
        if (i1 < n1 && s1.charAt(i1) == s3.charAt(i1 + i2))
            take1 = dfs(i1 + 1, i2, s1, s2, s3);
        if (i2 < n2 && s2.charAt(i2) == s3.charAt(i1 + i2))
            take2 = dfs(i1, i2 + 1, s1, s2, s3);
        return take1 || take2;
    }
}
