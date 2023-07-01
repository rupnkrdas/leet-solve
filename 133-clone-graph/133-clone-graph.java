/*
// Definition for a Node.
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
    Map<Node, Node> map = new HashMap<>();
    public void dfs(Node node, Node clone_node) {
        for (Node adj_node : node.neighbors) {
            if (map.containsKey(adj_node)) {
                clone_node.neighbors.add(map.get(adj_node));
            } else {
                Node adj_clone_node = new Node(adj_node.val);
                map.put(adj_node, adj_clone_node);
                clone_node.neighbors.add(adj_clone_node);
                dfs(adj_node, adj_clone_node);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Node clone_node = new Node(node.val);
        map.put(node, clone_node);

        dfs(node, clone_node);

        return clone_node;
    }
}