class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] vis = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, vis, adj);
            }
        }

        return count;
    }

    public void dfs(int node, int[] vis, List<List<Integer>> adj) {
        vis[node] = 1;

        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] == 0) {
                dfs(adjNode, vis, adj);
            }
        }
    }
}