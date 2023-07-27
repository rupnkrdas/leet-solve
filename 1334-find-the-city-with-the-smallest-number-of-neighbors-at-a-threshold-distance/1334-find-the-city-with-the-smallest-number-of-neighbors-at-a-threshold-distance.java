class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + "]";
    }
}
class Solution {
    private void dijkstra(int src, int[] dist, List<List<Pair>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        pq.offer(new Pair(0, src));
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.second;
            int distance = p.first;
            
            for (Pair adjPair : adj.get(node)) {
                int adjNode = adjPair.first;
                int wt = adjPair.second;
                
                if (distance + wt < dist[adjNode]) {
                    dist[adjNode] = distance + wt;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                }
            }
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        
        int[] dist = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(i, dist, adj);
            for (int j = 0; j < n; j++) {
                if (dist[j] <= distanceThreshold && i != j) {
                    count[i]++;
                }
            }
        }
        
        System.out.println(Arrays.toString(count));
        int mini = Integer.MAX_VALUE;
        int ans_node = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] <= mini) {
                mini = count[i];
                ans_node = i;
            }
        }
        
        return ans_node;
    }
}