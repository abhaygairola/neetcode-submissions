class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        int visitedArray[][] = new int[m][n];
        for (int dp[] : visitedArray) {
            Arrays.fill(dp, 0);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visitedArray[i][j] == 0) {
                    bfs(grid, i, j, visitedArray);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(char[][] grid, int i, int j, int vistedArray[][]) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        vistedArray[i][j] = 1;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            int adj[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int a[] : adj) {
                int ar = r + a[0];
                int ac = c + a[1];
                if (ar >= 0 && ar < m && ac >= 0 && ac < n && grid[ar][ac] == '1'
                    && vistedArray[ar][ac] == 0) {
                    q.add(new int[] {ar, ac});
                    vistedArray[ar][ac] = 1;
                }
            }
        }
    }
}
