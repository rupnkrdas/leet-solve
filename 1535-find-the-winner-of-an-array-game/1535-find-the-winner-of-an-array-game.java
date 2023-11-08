class Solution {
    public int getWinner(int[] arr, int k) {
        int N = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
        pq.offer(arr[0]);
        for (int i = 1; i < N; i++) {
            if (arr[i] < pq.peek()) cnt++;
            else {
                pq.offer(arr[i]);
                cnt = 1;
            }

            if (cnt == k) return pq.poll();
        }

        return pq.peek();
    }
}