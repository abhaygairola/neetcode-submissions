class Solution {
    public int characterReplacement(String s, int k) {
        int r = 0, l = 0, maxf = 0, n = s.length(), maxl = 0;
        Map<Character, Integer> cnt = new HashMap<>();
        while (r < n) {
            char c = s.charAt(r);
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            maxf = Math.max(cnt.get(c), maxf);
            if (r - l + 1 - maxf > k) {
                char crm = s.charAt(l);
                cnt.put(crm, cnt.get(crm) - 1);
                l++;
            }
            maxl = Math.max(r - l + 1, maxl);
            ;
            r++;
        }
        return maxl;
    }
}
