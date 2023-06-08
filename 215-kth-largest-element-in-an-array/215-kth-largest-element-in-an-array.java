class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }
}