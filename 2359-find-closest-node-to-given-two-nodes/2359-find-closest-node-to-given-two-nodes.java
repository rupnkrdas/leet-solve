class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] dijkstra(int start, List<List<Integer>> adj, int n) {
        int[] ans = new int[n];
        Arrays.fill(ans, (int)(1e9));
        ans[start] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        pq.offer(new Pair(0, start));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int distance = pair.first;
            int node = pair.second;

            for (int adjNode : adj.get(node)) {
                if (distance + 1 < ans[adjNode]) {
                    ans[adjNode] = distance + 1;
                    pq.offer(new Pair(ans[adjNode], adjNode));
                }
            }
        }

        return ans;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = i;
            int v = edges[i];

            if (v != -1) {
                adj.get(u).add(v);
            }
        }

        // System.out.println(adj);

        int[] dist1 = dijkstra(node1, adj, n);
        System.out.println(Arrays.toString(dist1));
        int[] dist2 = dijkstra(node2, adj, n);
        System.out.println(Arrays.toString(dist2));

        int ans = 0;
        int maxi = (int)(1e9);
        for (int i = 0; i < n; i++) {
            int d1 = dist1[i];
            int d2 = dist2[i];
            if (Math.max(d1, d2) < maxi) {
                maxi = Math.max(d1, d2);
                ans = i;
            }
        }
        return (maxi == (int)(1e9)) ? -1 : ans;
    }
}