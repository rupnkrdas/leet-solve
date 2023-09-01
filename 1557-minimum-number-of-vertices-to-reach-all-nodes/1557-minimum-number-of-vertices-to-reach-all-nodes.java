class Solution {
    private List<Integer> topo_sort(int n, List<List<Integer>> adj) {
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int adjNode : adj.get(i)) {
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }

        return topo;
    }
    private void dfs(int node, List<List<Integer>> adj, int[] vis) {
        vis[node] = 1;

        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] == 0) {
                dfs(adjNode, adj, vis);
            }
        }
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);

            adj.get(u).add(v);
        }

        int[] vis = new int[n];
        List<Integer> topo = topo_sort(n, adj);
        List<Integer> ans = new ArrayList<>();
        for (int node : topo) {
            if (vis[node] == 0) {
                ans.add(node);
                dfs(node, adj, vis);
            }
        }

        return ans;
    }
}