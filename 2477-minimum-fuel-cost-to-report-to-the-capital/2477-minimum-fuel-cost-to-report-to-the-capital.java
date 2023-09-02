class Solution {
    int SEATS;
    long fuel = 0;
    private long f(int node, int parent, List<List<Integer>> adj) {
        long people = 1;
        for (int adjNode : adj.get(node)) {
            if (adjNode != parent) {
                people += f(adjNode, node, adj);
            }
        }

        if (node != 0) {
            fuel += (int)Math.ceil(1.0*(people)/SEATS);
        }

        return people;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        SEATS = seats;
        List<List<Integer>> adj = new ArrayList<>();
        int n = roads.length;
        n++;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] r : roads) {
            int u = r[0];
            int v = r[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        f(0, -1, adj);
        return fuel;
    }
}