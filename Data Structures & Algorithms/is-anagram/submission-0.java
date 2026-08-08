class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> cnt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (cnt.containsKey(c)) {
                cnt.put(c, cnt.get(c) + 1);
            } else {
                cnt.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (cnt.containsKey(c)) {
                cnt.put(c, cnt.get(c) - 1);
                if (cnt.get(c) == 0) {
                    cnt.remove(c);
                }
            } else {
                return false;
            }
        }
        if(cnt.isEmpty()) return true;
        return false;
    }
}
