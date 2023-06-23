class Solution {
    public void dfs(int node, Map<Integer, Boolean> vis, Map<Integer, List<Integer>> adj, int[] ans, int i) {
        if (i == ans.length) return;

        ans[i] = node;
        vis.put(node, true);

        for (int adjNode : adj.get(node)) {
            if (!vis.containsKey(adjNode)) {
                dfs(adjNode, vis, adj, ans, i + 1);
            }
        }
    }
    public int[] restoreArray(int[][] ap) {
        int n = ap.length;
        n = n + 1;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : ap) {
            int u = edge[0];
            int v = edge[1];

            if (adj.containsKey(u)) {
                adj.get(u).add(v);
            } else {
                adj.put(u, new ArrayList<>());
                adj.get(u).add(v);
            }
            if (adj.containsKey(v)) {
                adj.get(v).add(u);
            } else {
                adj.put(v, new ArrayList<>());
                adj.get(v).add(u);
            }
        }

        int src = 0;
        for (Map.Entry<Integer, List<Integer>> e : adj.entrySet()) {
            if (e.getValue().size() == 1) {
                src = e.getKey();
            }
        }

        int[] ans = new int[n];
        Map<Integer, Boolean> vis = new HashMap<>();
        dfs(src, vis, adj, ans, 0);
        return ans;
    }
}