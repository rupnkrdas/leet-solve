class Solution {
    private boolean dfs(int node, int[] vis, int[] pathVis, int[] check, int[][] graph) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int adjNode : graph[node]) {
            if (vis[adjNode] == 0) {
                if (dfs(adjNode, vis, pathVis, check, graph)) return true;
            } else if (pathVis[adjNode] == 1) return true;
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis       = new int[n];
        int[] pathVis   = new int[n];
        int[] check     = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, pathVis, check, graph);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 1) result.add(i);
        }


        return result;
    }
}