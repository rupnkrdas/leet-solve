class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Edge {
    int v;
    int wt;

    public Edge (int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : flights) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj[u].add(new Edge(v, wt));
        }

        Queue<Pair> pq = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new Pair(0, src));
        int steps = 0;
        while (!pq.isEmpty() && steps <= k) {
            int N = pq.size();
            while (N-- > 0) {
                Pair pair = pq.poll();
                int distance = pair.first;
                int node = pair.second;

                for (Edge e : adj[node]) {
                    int adjNode = e.v;
                    int wt = e.wt;

                    if (distance + wt < dist[adjNode]) {
                        dist[adjNode] = distance + wt;
                        pq.offer(new Pair(dist[adjNode], adjNode));
                    }
                }
            }
            steps++;
        }

        return (dist[dst] != Integer.MAX_VALUE) ? dist[dst] : -1;
    }
} 