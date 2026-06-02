class Solution {
    public String longestPalindrome(String s) {
        String[] pal = { "" };
        int n = s.length();
        for (int i = 0; i < n; i++) {
            palindrome(i, i, s, pal);
            palindrome(i, i + 1, s, pal);
        }
        return pal[0];
    }

    void palindrome(int left, int right, String s, String[] pal) {
        int n = s.length();

        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            if (pal[0].length() < right - left + 1) {
                pal[0] = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
    }
}