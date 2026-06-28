class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] v = new boolean[n];
        int tl=0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i =0;i<n;i++)adj.add(new ArrayList<Integer>());
        for(int[]e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for(int i =0;i<n;i++){
            if(!v[i]){
                tl++;
                dfs(i,v,adj);
            }
        }
    return tl;
    }


    private void dfs(int node, boolean[]v, List<List<Integer>> adj){
        v[node] = true;
        for(Integer a:adj.get(node)){
            if(!v[a]){
                dfs(a,v,adj);
            }
        }
    }
}
