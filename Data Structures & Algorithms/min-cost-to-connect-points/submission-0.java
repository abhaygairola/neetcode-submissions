class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int res =0;
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        //n^2
        for (int i = 0; i < n; i++) { //O(n)
            // finding minimum edge for all nodes instead of a pq - O(n)
            int node = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (node == -1 || dis[j] < dis[node] )) {
                    node = j;
                }
            }
            vis[node] = true;
            res+=dis[node];
            // adjacent will be all nodes not visited yet
            for (int k = 0; k < n; k++) {
                if (!vis[k]) {
                    int disMan = Math.abs(points[k][0] - points[node][0])
                        + Math.abs(points[k][1] - points[node][1]);
                    dis[k] = Math.min(dis[k], disMan);
                }
            }
        }
        return res;
    }
}
