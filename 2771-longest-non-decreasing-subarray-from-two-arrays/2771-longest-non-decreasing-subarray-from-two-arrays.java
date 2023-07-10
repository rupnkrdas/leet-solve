class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = 1 + f(i + 1, nums1, nums2, nums1[i]);
            int y = 1 + f(i + 1, nums1, nums2, nums2[i]);
            ans = Math.max(ans, Math.max(x, y));
        }
        
        return ans;
    }

    public int f(int idx, int[] nums1, int[] nums2, int prev) {
        if (idx >= nums1.length) return 0;

        String key = Integer.toString(idx) + "," + Integer.toString(prev);
        if (map.containsKey(key)) return map.get(key);

        int len = 0;
        if (nums1[idx] >= prev && nums2[idx] >= prev) {
            int x = f(idx + 1, nums1, nums2, nums1[idx]);
            int y = f(idx + 1, nums1, nums2, nums2[idx]);

            len = 1 + Math.max(x, y);
        }
        else if (nums1[idx] >= prev) {
            len = 1 + f(idx + 1, nums1, nums2, nums1[idx]);
        }
        else if (nums2[idx] >= prev) {
            len = 1 + f(idx + 1, nums1, nums2, nums2[idx]);
        }

        map.put(key, len);
        return len;
    }
}