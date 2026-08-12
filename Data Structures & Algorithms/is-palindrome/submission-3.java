class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toUpperCase();
        int l = str.length();
        int i = 0, j = l - 1;
        while (i < j) {
            char st = str.charAt(i);
            char ed = str.charAt(j);
            if (!((st >='A' && st <= 'Z')||(st >='0' && st <= '9'))){
                i++;
                continue;
            } else if (!((ed >='A' && ed <= 'Z')||(ed >='0' && ed <= '9'))) {
                j--;
                continue;
            } else if (st != ed) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
