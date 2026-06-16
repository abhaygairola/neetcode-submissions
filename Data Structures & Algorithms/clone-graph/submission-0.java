/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Integer, Node> visited) {
        int value = node.val;
        ArrayList<Node> newNeighbors = new ArrayList<>();
        Node deepCopy = new Node(value, newNeighbors);
        visited.put(value, deepCopy);

        for (Node adj : node.neighbors) {
            if (!visited.containsKey(adj.val)) {
                dfs(adj, visited);
            }
            newNeighbors.add(visited.get(adj.val));
        }
        return deepCopy;
    }
}