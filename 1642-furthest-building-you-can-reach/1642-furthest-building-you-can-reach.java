class Solution {
    public int furthestBuilding(int[] h, int b, int l) {
        int n = h.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        for (; i < n - 1; i++) {
            int d = h[i + 1] - h[i];
            
            if (d <= 0) continue;
            if (b >= d) {
                b -= d;
                pq.offer(d);
            } 
            else if (l > 0) {
                if (!pq.isEmpty()) {
                    int maxBricksUsedPreviously = pq.peek();
                    if (maxBricksUsedPreviously >= d) {
                        b += pq.poll();
                        b -= d;
                        pq.offer(d);
                    }
                }
                l--;
            }
            else {
                break;
            }
        }

        return i;
    }
}