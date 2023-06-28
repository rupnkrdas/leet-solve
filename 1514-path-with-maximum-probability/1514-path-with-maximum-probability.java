class Pair1 {
    int first;
    double second;

    public Pair1(int first, double second) {
        this.first = first;
        this.second = second;
    }
}

class Pair2 {
    double first;
    int second;

    public Pair2(double first, int second) {
        this.first = first;
        this.second = second;
    }
}


class Solution {
    public double maxProbability(int n, int[][] edges, double[] prob, int start, int end) {
        // node -> [(adjNode, p), ...]
        List<List<Pair1>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = prob[i];

            adj.get(u).add(new Pair1(v, p));
            adj.get(v).add(new Pair1(u, p));
        }

        PriorityQueue<Pair2> pq = new PriorityQueue<>((x, y) -> Double.compare(y.first, x.first));

        double[] probability = new double[n];
        Arrays.fill(probability, 0);
        pq.offer(new Pair2(1, start));
        probability[start] = 1;
        while (!pq.isEmpty()) {
            Pair2 pair = pq.poll();
            double p = pair.first;
            int node = pair.second;

            for (Pair1 adjPair : adj.get(node)) {
                int adjNode = adjPair.first;
                double wt = adjPair.second;

                if (p*wt > probability[adjNode]) {
                    probability[adjNode] = p*wt;
                    pq.offer(new Pair2(probability[adjNode], adjNode));
                }
            }
        }

        return probability[end];
    }
}