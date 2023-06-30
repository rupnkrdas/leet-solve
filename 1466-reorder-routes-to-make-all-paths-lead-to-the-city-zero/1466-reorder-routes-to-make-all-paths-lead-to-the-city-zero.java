class Edge {
    int v;
    int isOriginal;

    public Edge (int v, int isOriginal) {
        this.v = v;
        this.isOriginal = isOriginal;
    }
} 
class Solution {
    public void dfs(int node, int parent, List<Edge>[] adj, int[] count) {
        for (Edge e : adj[node]) {
            int v = e.v;
            int isOriginal = e.isOriginal;
            if (v != parent) {
                if (isOriginal == 1) {
                    count[0]++;
                }
                dfs(v, node, adj, count);
            }
        }
    }
    public int minReorder(int n, int[][] edges) {
        List<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj[u].add(new Edge(v, 1)); // asli edge
            adj[v].add(new Edge(u, 0)); // nakli edge
        }

        int[] count = {0};
        dfs(0, -1, adj, count);

        return count[0];
    }
}