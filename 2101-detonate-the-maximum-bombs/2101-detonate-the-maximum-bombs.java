class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0], y1 = bombs[i][1], r = bombs[i][2];

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    long x = Math.abs(x1 - bombs[j][0]);
                    long y = Math.abs(y1 - bombs[j][1]);
                    if (x*x + y*y <= r*r) {
                        adj.get(i).add(j);
                    }
                }
            }
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] vis = new int[n];
            int[] count = {0};
            dfs(i, adj, vis, count);
            maxi = Math.max(maxi, count[0]);
        }

        return maxi;
    }

    public void dfs(int node, List<List<Integer>> adj, int[] vis, int[] count) {
        vis[node] = 1;
        count[0]++;

        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] == 0) {
                dfs(adjNode, adj, vis, count);
            }
        }
    }
}