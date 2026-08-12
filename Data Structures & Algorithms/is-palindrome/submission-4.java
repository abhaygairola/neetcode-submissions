class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toUpperCase();
        int l = str.length();
        int i = 0, j = l - 1;
        while (i < j) {
            char st = str.charAt(i);
            char ed = str.charAt(j);
            if (!isAlpanum(st)){
                i++;
                continue;
            } else if (!isAlpanum(ed)) {
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

    boolean isAlpanum(char c){
        return ((c >='A' && c <= 'Z')||(c >='0' && c <= '9') || (c >='a' && c <= 'z'));
    }
}
