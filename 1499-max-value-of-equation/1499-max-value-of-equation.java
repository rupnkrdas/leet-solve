class Solution {
    public int findMaxValueOfEquation(int[][] p, int k) {
        int n = p.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0]-p1[0]);
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            while(!pq.isEmpty() && p[j][0]-pq.peek()[1] > k) pq.poll();
            if (!pq.isEmpty()) {
                maxi = Math.max(maxi, p[j][0]+p[j][1] + pq.peek()[0]);
            }
            pq.offer(new int[]{p[j][1]-p[j][0], p[j][0]});
        }

        return maxi;
    }
}