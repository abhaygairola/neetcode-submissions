class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> cntT = new HashMap<>();
        Map<Character, Integer> cntW = new HashMap<>();

        for (char c : t.toCharArray()) {
            cntT.put(c, cntT.getOrDefault(c, 0) + 1);
        }

        int needMatches = cntT.size();
        int haveMatches = 0;

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int minL = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            cntW.put(c, cntW.getOrDefault(c, 0) + 1);

            // This character has JUST become satisfied.
            if (cntT.containsKey(c) &&
                cntW.get(c).equals(cntT.get(c))) {
                haveMatches++;
            }

            while (haveMatches == needMatches) {

                // Current window is valid
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minL = l;
                }

                char left = s.charAt(l);
                cntW.put(left, cntW.get(left) - 1);

                // Removing this character made its requirement unsatisfied
                if (cntT.containsKey(left) &&
                    cntW.get(left) < cntT.get(left)) {
                    haveMatches--;
                }

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minL, minL + minLen);
    }
}