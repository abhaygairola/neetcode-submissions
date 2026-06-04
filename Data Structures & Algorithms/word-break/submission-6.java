class Solution {
    Map<Integer, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<String>(wordDict);
        memo.put(s.length(), true);
        return dfs(s, wordSet, 0);
    }
    private boolean dfs(String s, Set<String> wordSet, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        for (int j = i; j < s.length(); j++) {
            if (wordSet.contains(s.substring(i, j + 1))) {
                if (dfs(s, wordSet, j + 1)) {
                    memo.put(i, true);
                    return true;
                }
            }
        }
        memo.put(i, false);
        return false;
    }
}
