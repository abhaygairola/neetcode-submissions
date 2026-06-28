class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] v = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());
        for (int e[] : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Queue<int[]> q = new LinkedList<>(); //{node,parent}

        q.add(new int[] {0, -1});
        v[0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int par = cur[1];

            for (Integer a : adj.get(node)) {
                if (!v[a]) {
                    q.add(new int[]{a, node});
                    v[a] = true;
                } else if (v[a] && par != a) {
                    return false;
                }
            }
        }

        for(int i =0 ; i< n ; i++){
            if(!v[i]) return false;
        }

        return true;
    }
}
