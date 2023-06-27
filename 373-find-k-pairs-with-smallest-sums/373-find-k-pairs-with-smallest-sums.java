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
        return this.first - other.first;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<Tuple> heap = new PriorityQueue<>();
        heap.offer(new Tuple(nums1[0] + nums2[0], 0, 0));
        List<List<Integer>> ans = new ArrayList<>();

        while (k-- > 0 && !heap.isEmpty()) {
            Tuple t = heap.poll();
            int i = t.second, j = t.third;
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[j]);
            ans.add(pair);

            if (i == j) { // go right, go left, go diagonal --> think of i,j to be forming a grid hypothetically
                if (i + 1 < n) heap.offer(new Tuple(nums1[i + 1] + nums2[j], i + 1, j));
                if (j + 1 < m) heap.offer(new Tuple(nums1[i] + nums2[j + 1], i, j + 1));
                if (i + 1 < n && j + 1 < m) heap.offer(new Tuple(nums1[i + 1] + nums2[j + 1], i + 1, j + 1));
            } else if (i > j && i + 1 < n) { // go down
                heap.offer(new Tuple(nums1[i + 1] + nums2[j], i + 1, j));
            } else if (j > i && j + 1 < m) { // go right
                heap.offer(new Tuple(nums1[i] + nums2[j + 1], i, j + 1));
            }
        }

        return ans;
    }
}