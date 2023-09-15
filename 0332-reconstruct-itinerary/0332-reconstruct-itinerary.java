class Solution {
    private void dfs(String node, Map<String, PriorityQueue<String>> adj, List<String> temp) {
        PriorityQueue<String> heap = adj.get(node);
        while (heap != null && !heap.isEmpty()) {
            String adjNode = heap.poll();
            dfs(adjNode, adj, temp);
        }
        temp.add(node);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        // Create a custom Comparator for lexical order
        Comparator<String> cmp = Comparator.naturalOrder();
        for (List<String> t : tickets) {
            String from = t.get(0);
            String to = t.get(1);

            if (!adj.containsKey(from)) {
                adj.put(from, new PriorityQueue<>(cmp));
            }
            adj.get(from).offer(new String(to));
        }
        // System.out.println("map : " + adj);

        List<String> ans = new ArrayList<>();
        dfs("JFK", adj, ans);

        Collections.reverse(ans);
        return ans;
    }
}