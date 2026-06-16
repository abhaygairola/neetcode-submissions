class Solution {
    int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxTime = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rot = false;
            for (int i = 0; i < size; i++) {
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];

                for (int d[] : dir) {
                    int ar = r + d[0];
                    int ac = c + d[1];
                    if (ar >= 0 && ar < m && ac >= 0 && ac < n && grid[ar][ac] == 1) {
                        grid[ar][ac] = 2;
                        rot = true;
                        q.add(new int[] {ar, ac});
                    }
                }
            }
            if (rot)
                maxTime++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return maxTime;
    }
}
