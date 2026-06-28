class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> t : tickets) {
            String fr = t.get(0);
            String to = t.get(1);
            if (adj.containsKey(fr)) {
                adj.get(fr).add(to);
            } else {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(to);
                adj.put(fr, pq);
            }
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
