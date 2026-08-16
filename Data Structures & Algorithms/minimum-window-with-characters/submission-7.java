// IMPORTANT: cntT/cntW store Integer objects.
// Never use == to compare Integer values (especially >127), because == compares
// object references due to Integer caching. Use .equals() or unbox to int.
// Example: cntT.get(c).equals(cntW.get(c))
class Solution {
    public String minWindow(String s, String t) {
        int maxlen = Integer.MAX_VALUE;
        int[] maxind = new int[2];

        Map<Character, Integer> cntT = new HashMap<>();
        Map<Character, Integer> cntW = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            cntT.put(c, cntT.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int needMatches = cntT.size();
        int haveMatches = 0;
        for (int r = 0; r < s.length(); r++) {
            Character cr = s.charAt(r);
            cntW.put(cr, cntW.getOrDefault(cr, 0) + 1);
            if (cntT.getOrDefault(cr, 0).equals(cntW.get(cr)))
             {
                haveMatches++;
            }
            while (haveMatches == needMatches) {
                if (r - l + 1 < maxlen) {
                    maxlen = r - l + 1;
                    maxind[0] = l;
                    maxind[1] = r;
                }
                Character cl = s.charAt(l);
                cntW.put(cl, cntW.get(cl) - 1);
                if (cntT.containsKey(cl) && cntT.get(cl) > cntW.get(cl)) {
                    haveMatches--;
                }
                l++;
            }
        }

        return maxlen == Integer.MAX_VALUE ? "" : s.substring(maxind[0], maxind[1] + 1);
    }
}
