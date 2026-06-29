class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<int[]>());
        }
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[] {f[1], f[2]});
        }

        int[][] dis = new int[n][k + 2];
        for (int[] d : dis) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cCost = cur[0];
            int cNode = cur[1];
            int cStops = cur[2];
            if (cNode == dst) {
                return cCost;
            }
            if (cStops == k + 1) {
                continue;
            }

            for(int[] a:adj.get(cNode)){
                int aPrice= a[1];
                int aNode = a[0];

                if(dis[aNode][cStops+1]>cCost+aPrice){
                   dis[aNode][cStops+1]=cCost+aPrice;
                   pq.add(new int []{dis[aNode][cStops+1],aNode,cStops+1});
                }

            }
        }
        return -1;
    }
}
