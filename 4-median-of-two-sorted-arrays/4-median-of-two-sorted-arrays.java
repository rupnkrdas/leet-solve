class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int start = 0;
        int end = n1;

        while (start <= end) {
            int cut1 = start + (end - start)/2;
            int cut2 = (n1 + n2 + 1)/2 - cut1;

            // System.out.println("cut1 : " + cut1 + " cut2 : " + cut2);

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 > r2) {
                end = cut1 - 1;
            } else if (l2 > r1) {
                start = cut1 + 1;
            } else {
                if ((n1 + n2) % 2 == 0) {
                    int leftMedian = Math.max(l1, l2);
                    int rightMedian = Math.min(r1, r2);
                    return (leftMedian + rightMedian) / 2.0;
                }
                else return Math.max(l1, l2);
            }
        }

        return -1;
    }
}