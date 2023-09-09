class Solution {
    public int[] loudAndRich(int[][] grid, int[] nums) {
        int n = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] e : grid) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
            ans[i] = i;
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adjNode : adj.get(node)) {
                if (nums[node] < nums[adjNode]) {
                    nums[adjNode] = nums[node];
                    ans[adjNode] = ans[node];
                }
                indegree[adjNode]--;
                if (indegree[adjNode] == 0)q.offer(adjNode);
            }
        }

        return ans;
    }
}