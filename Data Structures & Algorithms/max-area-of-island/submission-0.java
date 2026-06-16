class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        int visitedArray[][] = new int[m][n];
        for (int dp[] : visitedArray) {
            Arrays.fill(dp, 0);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visitedArray[i][j] == 0) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, visitedArray));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int vistedArray[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int totalarea = 1;
        vistedArray[i][j] = 1;

        int adj[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int a[] : adj) {
            int ar = i + a[0];
            int ac = j + a[1];
            if (ar >= 0 && ar < m && ac >= 0 && ac < n && grid[ar][ac] == 1
                && vistedArray[ar][ac] == 0) {
                totalarea += dfs(grid, ar, ac, vistedArray);
            }
        }
        return totalarea;
    }
}
