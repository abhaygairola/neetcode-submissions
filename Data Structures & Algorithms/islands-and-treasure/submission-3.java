class Solution {
    int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d[] : dir) {
                int ar = r + d[0];
                int ac = c + d[1];
                if (ar >= 0 && ar < m && ac >= 0 && ac < n && grid[ar][ac] == Integer.MAX_VALUE) {
                    grid[ar][ac] = grid[r][c] + 1;
                    q.add(new int[] {ar, ac});
                }
            }
        }
    }
}
