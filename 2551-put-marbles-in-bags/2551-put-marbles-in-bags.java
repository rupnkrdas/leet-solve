class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        PriorityQueue<Long> min_heap = new PriorityQueue<>();
        PriorityQueue<Long> max_heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            min_heap.offer((long)weights[i] + (long)weights[i + 1]);
            max_heap.offer((long)weights[i] + (long)weights[i + 1]);
            if (min_heap.size() > k - 1) {
                min_heap.poll();
            }
            if (max_heap.size() > k - 1) {
                max_heap.poll();
            }
        }

        long maxi = 0;
        while (!min_heap.isEmpty()) {
            maxi += min_heap.poll();
        }
        long mini = 0;
        while (!max_heap.isEmpty()) {
            mini += max_heap.poll();
        }

        return maxi - mini;
    }
}