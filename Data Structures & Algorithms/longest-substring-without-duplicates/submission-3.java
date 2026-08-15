class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        Map<Character, Integer> c = new HashMap<>();
        int n = s.length();
        int l = 0, r = 0;
        while (r < n) {
            char cur = s.charAt(r);
            if(c.containsKey(cur) && c.get(cur)>=l){
                l=c.get(cur)+1;                
            }
            c.put(cur,r);
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}
