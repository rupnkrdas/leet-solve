class Solution {
    public void dfs(int node, List<List<Integer>> rooms, int[] vis) {
        vis[node] = 1;

        for (int room : rooms.get(node)) {
            if (vis[room] == 0) {
                dfs(room, rooms, vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] vis = new int[n];
        dfs(0, rooms, vis);

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) return false;
        }
        return true;
    }
}