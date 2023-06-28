class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];

        int time = solve(0, vis, adj, hasApple);

        return time;
    }

    // hypothesis: solve function returns the time
    public int solve(int node, int[] vis, List<List<Integer>> adj, List<Boolean> hasApple) {
        vis[node] = 1;
        int time = 0;

        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] == 0) {
                int child_time = solve(adjNode, vis, adj, hasApple);
                if (child_time > 0 || hasApple.get(adjNode)) {
                    time += 2 + child_time;
                }
            }
        }

        return time;
    }
}