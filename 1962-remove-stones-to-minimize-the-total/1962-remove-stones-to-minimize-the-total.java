class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : piles) {
            pq.offer(num);
            sum += num;
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int num = pq.poll();
            int remove = (int)Math.floor(num / 2);
            num -= remove;
            sum -= remove;
            pq.offer(num);
        }

        return sum;
    }
} 