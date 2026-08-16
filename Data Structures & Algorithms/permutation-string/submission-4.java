class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) {
            return false;
        }
        int l = 0;
        int r = n1 - 1;
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        int matches = 0;

        for (int i = 0; i < n1; i++) {
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (f1[i] == f2[i]) {
                matches++;
            }
        }

        while (r < n2 - 1) {
            if (matches == 26) {
                return true;
            }
            r++;
            int rc = s2.charAt(r) - 'a';
            f2[rc]++;
            if (f1[rc] == f2[rc]) {
                matches++;
            } else if (f1[rc] == f2[rc] - 1) {
                matches--;
            }
            
            int lc = s2.charAt(l) - 'a';
            f2[lc]--;
            if (f1[lc] == f2[lc]) {
                matches++;
            } else if (f1[lc] == f2[lc] + 1) {
                matches--;
            }
            l++;
        }

        return matches == 26;
    }
}
