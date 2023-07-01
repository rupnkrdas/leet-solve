class Solution {
    int result = -1;
    public void dfs(int node, int[] vis, int[] pathVis, List<List<Integer>> adj, int[] count) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] == 0) {
                count[adjNode] = count[node] + 1;
                dfs(adjNode, vis, pathVis, adj, count);
            } else if (pathVis[adjNode] == 1) { // cycle present
                result = Math.max(result, count[node] - count[adjNode] + 1);
            }
        }

        pathVis[node] = 0;
    }
    public int longestCycle(int[] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = i;
            int v = edges[i];
            if (v != -1) {
                adj.get(u).add(v);
            }
        }

        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, pathVis, adj, count);
            }
        }

        return result;
    }
}