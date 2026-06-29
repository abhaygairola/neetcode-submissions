class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] c = copyA(dis);
            for (int[] f : flights) {
                int s = f[0];
                int d = f[1];
                int p = f[2];
                if(c[s]==Integer.MAX_VALUE ) continue;
                if (dis[d] > c[s] + p) {
                    dis[d] = c[s] + p;
                }
            }
        }
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }

    private int[] copyA(int[] a) {
        int n = a.length;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = a[i];
        }
        return d;
    }
}
