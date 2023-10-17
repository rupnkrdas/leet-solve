class Solution {
    private boolean dfs(int node, int parent, List<List<Integer>> adj, int[] vis) {
        vis[node] = 1;
        // pathVis[node] = 1;

        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] != 1) {
                if (dfs(adjNode, node, adj, vis)) return true;
            } else if (adjNode != parent) {
                return true;
            }
        }

        // pathVis[node] = 0;
        return false;
    }
    public boolean validateBinaryTreeNodes(int N, int[] l, int[] r) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (l[i] != -1) {
                if(set.contains(l[i])) return false;
                set.add(l[i]);
                adj.get(i).add(l[i]);
                adj.get(l[i]).add(i);
            }
            if (r[i] != -1) {
                if(set.contains(r[i])) return false;
                set.add(r[i]);
                adj.get(i).add(r[i]);
                adj.get(r[i]).add(i);
            }
        }

        int[] vis = new int[N];
        // int[] pathVis = new int[N];
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                if (flag) return false;
                flag = true;
                if (dfs(i, -1, adj, vis)) return false;
            }
        }

        return true;
    }
}