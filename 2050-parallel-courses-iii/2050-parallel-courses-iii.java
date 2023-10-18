class Solution {
    public int minimumTime(int n, int[][] r, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : r) {
            int u = e[0];
            int v = e[1];

            adj.get(u-1).add(v-1);
            indegree[v-1]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] maxTime = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                maxTime[i] = time[i];
            }
        }

        int maxi = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            maxi = Math.max(maxi, maxTime[node]);
            for (int adjNode : adj.get(node)) {
                maxTime[adjNode] = Math.max(maxTime[adjNode], maxTime[node] + time[adjNode]);
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) q.offer(adjNode);
            }
        }

        return maxi;
    }
}