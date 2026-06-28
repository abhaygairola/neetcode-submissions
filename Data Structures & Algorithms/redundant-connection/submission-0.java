class Solution {
    class DisjointSet {
        int parent[];
        int rank[];
        public DisjointSet(int n) {
            parent = new int[n+1];
            rank = new int[n+1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }
        public int findParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
        public boolean unionByRank(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            //cycle detection
            if(pu == pv){
                return false;
            }

            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else {
                parent[pu] = pv;
                rank[pv]++;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);

        for (int[] e : edges) {
            if (!ds.unionByRank(e[0], e[1])) {
                return e;
            }
        }
        return new int[] {-1, -1};
    }
}
