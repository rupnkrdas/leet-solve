class Solution {
    public boolean isSafe(int i, int n) {
        return (i >= 0 && i < n);
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>(); // (num) -> List<indices>
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            }
        }

        int[] vis = new int[n];
        int jumps = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int node = q.poll();
                if (node == n - 1) return jumps;

                if (isSafe(node - 1, n) && vis[node - 1] == 0) {
                    vis[node - 1] = 1;
                    q.offer(node - 1);
                } 
                if (isSafe(node + 1, n) && vis[node + 1] == 0) {
                    vis[node + 1] = 1;
                    q.offer(node + 1);
                }
                List<Integer> adjNodes = map.get(nums[node]);
                if (adjNodes != null) {
                    for (int adjNode : adjNodes) {
                        if (vis[adjNode] == 0) {
                            vis[adjNode] = 1;
                            q.offer(adjNode);
                        }
                    }
                }
                map.remove(nums[node]);
            }

            jumps++;
        }

        return -1;
    }
}