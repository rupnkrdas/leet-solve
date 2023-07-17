class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp    = nums[i];
        nums[i]     = nums[j];
        nums[j]     = temp;
    }
    public void sortColors(int[] nums) {
        // use 3-pointers
        // left     <-- points to 0
        // mid      <-- points to 1
        // right    <-- points to 2

        int left = 0, mid = 0, n = nums.length, right = n - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, right);
                right--;
            }
        }
    }
}