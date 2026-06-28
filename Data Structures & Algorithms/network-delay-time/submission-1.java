class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int maxDistance = -1;
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<int[]>());
        }
        for (int[] t : times) {
            adj.get(t[0]).add(new int[] {t[1], t[2]});
        }
        // {distance,node}
        PriorityQueue<Integer[]> pq =
            new PriorityQueue<>((a, b) -> { return Integer.compare(a[0], b[0]); });
        pq.add(new Integer[] {0, k});
        distance[k] = 0;

        while (!pq.isEmpty()) {
            Integer cur[] = pq.poll();
            int node = cur[1];
            int dis = cur[0];
            for (int a[] : adj.get(node)) {
                int adjNode = a[0];
                int adjWeight = a[1];
                if (distance[adjNode] > dis + adjWeight) {
                    distance[adjNode] = dis + adjWeight;
                    pq.add(new Integer[] {distance[adjNode], adjNode});
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                return -1;
            maxDistance = Math.max(maxDistance, distance[i]);
        }
        return maxDistance;
    }
}
