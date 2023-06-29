class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public void dfs(int node, ArrayList<Integer>[] adj, int distance, int[] dist, int[] vis) {
        vis[node] = 1;

        for (int adjNode : adj[node]) {
            if (vis[adjNode] == 0) {
                if (distance + 1 < dist[adjNode]) {
                    dist[adjNode] = distance + 1;
                }
                dfs(adjNode, adj, distance + 1, dist, vis);
            }
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int u = i;
            int v = edges[i];

            if (v != -1) {
                adj[u].add(v);
            }
        }

        int[] dist1 = new int[n];
        int[] vis = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dfs(node1, adj, 0, dist1, vis);

        int[] dist2 = new int[n];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist2[node2] = 0;
        Arrays.fill(vis, 0);
        dfs(node2, adj, 0, dist2, vis);

        int ans = -1;
        int minDistanceTillNode = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (Math.max(dist1[i], dist2[i]) < minDistanceTillNode) {
                minDistanceTillNode = Math.max(dist1[i], dist2[i]);
                ans = i;
            }
        }

        return ans;
    }
}
