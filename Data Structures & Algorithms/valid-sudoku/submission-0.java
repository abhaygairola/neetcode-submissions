class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> sqrs = new HashMap<>();
        int r = board.length;
        int c = board[1].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                String sqrKey = (char)(i/3) +","+ (char)(j/3);
                char cur = board[i][j];
                if (cur == '.') continue;

                if(cols.computeIfAbsent(i,k->new HashSet<>()).contains(cur)||
                   rows.computeIfAbsent(j,k->new HashSet<>()).contains(cur)||
                   sqrs.computeIfAbsent(sqrKey,k->new HashSet<>()).contains(cur)){
                    return false;
                }
                cols.get(i).add(cur);
                rows.get(j).add(cur);
                sqrs.get(sqrKey).add(cur);
            }
        }
        return true;
    }
}
