class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int val : map.values()) pq.offer(val);

        while (pq.size() >= 2) {
            int max1 = pq.poll();
            int max2 = pq.poll();

            max1--;
            max2--;
            
            if (max1 > 0) pq.offer(max1);
            if (max2 > 0) pq.offer(max2);
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        return ans;
    }
}