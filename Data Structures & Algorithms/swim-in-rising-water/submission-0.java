class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean vis[][] = new boolean[r][c];
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> { return Integer.compare(a[0], b[0]); }); // weight,x,y
        pq.add(new int[] {grid[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cr = cur[1];
            int cc = cur[2];
            int cw = cur[0];
            if (cr == r - 1 && cc == c - 1)
                return cw;
            vis[cr][cc] = true;
            for (int[] d : dir) {
                int ar = d[0] + cr;
                int ac = d[1] + cc;
                if (ar >= 0 && ar < r && ac >= 0 && ac < c && !vis[ar][ac]) {
                    pq.add(new int[] {Math.max(grid[ar][ac], cw), ar, ac});
                }
            }
        }

        return -1;
    }
}
