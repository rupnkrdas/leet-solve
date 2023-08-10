class Solution {
    private int findPivot(int[] nums) {
        int start = 0;
        int n = nums.length, end = n - 1;

        while (start < end) {
            int mid = start + (end - start)/2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
    private int bs(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start)/2;

            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int n = nums.length;
        if (pivot == 0) return bs(nums, 0, n - 1, target);
        else {
            int left = bs(nums, 0, pivot - 1, target);
            return (left != -1) ? left : bs(nums, pivot, n - 1, target);
        }
    }
}