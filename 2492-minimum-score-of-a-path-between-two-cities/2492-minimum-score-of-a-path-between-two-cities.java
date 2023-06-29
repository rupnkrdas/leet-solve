class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Edge {
    int v;
    int wt;

    public Edge (int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}
class Solution {
    public void dfs(int node, List<Edge>[] adj, int[] vis, int[] dist) {
        vis[node] = 1;

        for (Edge e : adj[node]) {
            int adjNode = e.v;
            int wt = e.wt;
            dist[0] = Math.min(dist[0], wt);
            if (vis[adjNode] == 0) {
                dfs(adjNode, adj, vis, dist);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        List<Edge>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : roads) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj[u].add(new Edge(v, wt));
            adj[v].add(new Edge(u, wt));
        }

        int[] dist = {Integer.MAX_VALUE};
        int[] vis = new int[n + 1];
        dfs(1, adj, vis, dist);

        return dist[0];
    }
}