class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = manager[i];
            if (u == -1) {
                continue;
            } else {
                int v = i;
                adj.get(u).add(v);
            }
        }

        int[] times = new int[n];
        Arrays.fill(times, (int)1e9);
        times[headID] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.second - y.second);
        q.offer(new Pair(headID, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.first;
            int tm = pair.second;

            for (int adjNode : adj.get(node)) {
                if (tm + informTime[node] < times[adjNode]) {
                    times[adjNode] = tm + informTime[node];
                    q.offer(new Pair(adjNode, times[adjNode]));
                }
            }
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, times[i]);
        }

        return maxi;
    }
}