class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> t : tickets) {
            adj.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        }

        dfs("JFK", adj, result);
        return result;
    }
    private void dfs(
        String Node, Map<String, PriorityQueue<String>> adj, LinkedList<String> result) {
        PriorityQueue<String> pq = adj.get(Node);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), adj, result);
        }
        result.addFirst(Node);
    }
}
