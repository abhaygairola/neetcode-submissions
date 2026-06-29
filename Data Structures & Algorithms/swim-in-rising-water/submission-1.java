class Solution {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dist = new int[r][c];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> { return Integer.compare(a[0], b[0]); }); // weight,x,y
        pq.add(new int[] {grid[0][0], 0, 0});
        dist[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cr = cur[1];
            int cc = cur[2];
            int cw = cur[0];

            if (cw > dist[cr][cc])
                continue;

            if (cr == r - 1 && cc == c - 1)
                return cw;

            for (int[] d : dir) {
                int ar = d[0] + cr;
                int ac = d[1] + cc;
                if (ar >= 0 && ar < r && ac >= 0 && ac < c
                    && dist[ar][ac] > Math.max(grid[ar][ac], cw)) {
                    dist[ar][ac] = Math.max(grid[ar][ac], cw);
                    pq.add(new int[] {dist[ar][ac], ar, ac});
                }
            }
        }

        return dist[r - 1][c - 1];
    }
}
