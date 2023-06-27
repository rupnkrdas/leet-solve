class Tuple implements Comparable<Tuple> {
    int first;
    int second;
    int third;

    public Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int compareTo(Tuple other) {
        return (this.first + this.second) - (other.first + other.second);
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ans;
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new Tuple(nums1[i], nums2[0], 0));
        }
        while (k-- > 0 && !minHeap.isEmpty()) {
            Tuple tuple = minHeap.poll();
            int x = tuple.first;
            int y = tuple.second;
            int index = tuple.third;
            List<Integer> list = new ArrayList<>();
            list.add(x);
            list.add(y);
            ans.add(list);

            if (index == nums2.length - 1) {
                continue;
            }

            minHeap.offer(new Tuple(x, nums2[index + 1], index + 1));
        }

        return ans;
    }
}