class Solution {
    List<Integer> list = new ArrayList<>();
    private void dfs(int node, Map<Integer, List<Integer>> adj, Set<Integer> vis) {
        vis.add(node);
        list.add(node);

        for (int adjNode : adj.get(node)) {
            if (!vis.contains(adjNode)) dfs(adjNode, adj, vis);
        }

        return;
    }
    public int[] restoreArray(int[][] pairs) {
        // 2 -> 1, 1 -> 2
        // 3 -> 4, 4 -> 3
        // 3 -> 2, 2 -> 3
        Map<Integer, List<Integer>> map = new HashMap<>();
        int N = pairs.length + 1;
        
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int[] p : pairs) {
            int u = p[0];
            int v = p[1];

            if (!map.containsKey(u)) map.put(u, new ArrayList<>());
            if (!map.containsKey(v)) map.put(v, new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
            
            indegree.put(u, indegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }

        
        Set<Integer> vis = new HashSet<>();
        for (int u : map.keySet()) {
            if (indegree.get(u) == 1) {
                dfs(u, map, vis);
                break;
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);

        return ans;
    }
}