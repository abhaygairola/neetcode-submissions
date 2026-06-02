class Solution {
    public String longestPalindrome(String s) {
        String pal = new String();
        int maxPal = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String temp = palindrome(i, i, s, maxPal);
            if (temp.length() > maxPal) {
                maxPal = temp.length();
                pal = new String(temp);
            }

            temp = palindrome(i - 1, i, s, maxPal);
            if (temp.length() > maxPal) {
                maxPal = temp.length();
                pal = new String(temp);
            }
        }
        return pal;
    }

    String palindrome(int left, int right, String s, int maxPal) {
        int n = s.length();
        String pal = new String();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            if (maxPal < right - left + 1) {
                maxPal = right - left + 1;
                pal = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
        return pal;
    }
}
