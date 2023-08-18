class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // Map<Integer, Map<Integer, Boolean>> adj = new HashMap<>();
        // for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        Set<String> set = new HashSet<>();
        int[] indegree = new int[n];
        for (int[] r : roads) {
            int u = r[0];
            int v = r[1];

            indegree[u]++;
            indegree[v]++;

            String key1 = Integer.toString(u) + "," + Integer.toString(v);
            String key2 = Integer.toString(v) + "," + Integer.toString(u);

            set.add(key1);
            set.add(key2);
            // set.add(new int[]{v, u});

            // if (!adj.containsKey(u)) {
            //     adj.put(u, new HashMap<>());
            // }
            // if (!adj.containsKey(u)) {
            //     adj.put(u, new HashMap<>());
            // }

            // adj.get(u).put(v, true);
            // adj.get(v).put(u, true);
        }

        int maxi = Integer.MIN_VALUE;
        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                String key1 = Integer.toString(u) + "," + Integer.toString(v);
                String key2 = Integer.toString(v) + "," + Integer.toString(u);

                if (set.contains(key1) || set.contains(key2)) {
                    maxi = Math.max(maxi, indegree[u]+indegree[v]-1);
                } else {
                    maxi = Math.max(maxi, indegree[u]+indegree[v]);
                }

                // System.out.println("maxi = " + maxi + " u : " + u + " v : " + v);
            }
        }

        return maxi;
    }
}