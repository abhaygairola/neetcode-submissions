class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        char[][] map = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        dfs(digits, 0, res, new StringBuilder(), map);
        return res;
    }

    void dfs(String digits, int ind, List<String> res, StringBuilder sb, char[][] map) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int n = Integer.parseInt(digits.charAt(ind) + "");
        for(char c : map[n-2]){
            sb.append(c);
            dfs(digits, ind+1, res, sb, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
