class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> topoSort = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }

        int[] inDegree = new int[numCourses];
        // initialize indegree array and adj list
        for (int[] i : prerequisites) {
            adj.get(i[1]).add(i[0]);
            inDegree[i[0]]++;
        }

        for (int i = 0; i<numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            topoSort.add(curr);
            for(int a:adj.get(curr)){
                inDegree[a]--;
                if(inDegree[a]==0) q.add(a);
            }

        }
                return (topoSort.size() == numCourses)?topoSort.stream()
                                   .mapToInt(Integer::intValue)
                                   .toArray():new int[0];
       
    }
}
