class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = i;
            for (int v : graph[i]) {
                adj.get(i).add(v);
            }
        }

        dfs(0, n, new ArrayList<>(), adj);
        return ans;
    }

    public void dfs(int node, int n, List<Integer> list, List<List<Integer>> adj) {
        if (node == n - 1) {
            list.add(node);
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }


        list.add(node);
        for (int adjNode : adj.get(node)) {
            dfs(adjNode, n, list, adj);
        }
        list.remove(list.size() - 1);
    }
}