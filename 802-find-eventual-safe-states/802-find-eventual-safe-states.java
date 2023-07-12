class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int v : graph[i]) {
                adj.get(v).add(i);
            }
        }
        
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
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

        Collections.sort(topo);
        return topo;
    }
}