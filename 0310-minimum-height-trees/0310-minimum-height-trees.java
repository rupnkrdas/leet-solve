class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) return ans;
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            indegree[u]++;
            indegree[v]++;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int node = 0; node < n; node++) {
            if (indegree[node] == 1) {
                q.add(node);
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;
            while (size-- > 0) {
                int node = q.poll();

                for(int adjNode : adj.get(node)) {
                    indegree[adjNode]--;
                    if (indegree[adjNode] == 1) q.offer(adjNode);
                }
            }
        }

        ans.addAll(q);
        return ans;
    }
}