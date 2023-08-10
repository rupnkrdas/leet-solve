class Solution {
    private int findPivot(int[] nums) {
        int start = 0;
        int n = nums.length, end = n-1;

        while (start < end) {
            while (start < end && nums[start] == nums[start + 1]) {
                start++;
            }
            while (start < end && nums[end] == nums[end - 1]) {
                end--;
            }
            int mid = start + (end - start)/2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
    private boolean bs(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start)/2;

            if (target == nums[mid]) return true;
            else if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }

        return false;
    }
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums);

        if (pivot == 0) {
            return bs(nums, 0, n - 1, target);
        } else {
            boolean left = bs(nums, 0, pivot-1, target);
            return (left) ? left : bs(nums, pivot, n - 1, target);
        }
    }
}