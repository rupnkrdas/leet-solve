class Solution {
    private boolean f(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid] == target) return true;
            if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
    public int getCommon(int[] nums1, int[] nums2) {
        for (int num : nums1) {
            if (f(nums2, num)) return num;
        }

        return -1;
    }
}