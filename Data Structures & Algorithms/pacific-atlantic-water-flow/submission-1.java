class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // pacific c=0 or r=0
        // atlantic c =m or r =n

        int n = heights.length;
        int m = heights[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] vistedPacific = new int[n][m];
        int[][] vistedAtlantic = new int[n][m];

        for (int i = Math.max(n, m)-1; i >= 0; i--) {
            if (i < m){
                q.add(new int[] {0, i});
                vistedPacific[0][i] = 1;
                }
            if (i < n && i!=0){
                q.add(new int[] {i, 0});
                vistedPacific[i][0] = 1;
                }
        }

        



        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];            

            for (int[] dir : directions) {
                int ar = r + dir[0];
                int ac = c + dir[1];
                if (ar >= 0 && ar < n && ac >= 0 && ac < m && heights[ar][ac] >= heights[r][c]
                    && vistedPacific[ar][ac] != 1) {
                    q.add(new int[] {ar, ac});
                    vistedPacific[ar][ac] = 1;
                }
            }
        }

        for (int i = Math.max(n, m)-1; i >= 0; i--) {
            if (i < m)
                {q.add(new int[] {n - 1, i});vistedAtlantic[n - 1][i] = 1;}
            if (i < n-1 )
               { q.add(new int[] {i, m - 1});vistedAtlantic[i][m - 1] = 1;}
        }

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int[] dir : directions) {
                int ar = r + dir[0];
                int ac = c + dir[1];
                if (ar >= 0 && ar < n && ac >= 0 && ac < m && heights[ar][ac] >= heights[r][c]
                    && vistedAtlantic[ar][ac] != 1) {
                    q.add(new int[] {ar, ac});
                    vistedAtlantic[ar][ac] = 1;
                }
            }
        }

        List<List<Integer>> merged = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vistedAtlantic[i][j] == 1 && vistedPacific[i][j] == 1)
                    merged.add(new ArrayList<>(List.of(i, j)));
            }
        }

        return merged;
    }
}
