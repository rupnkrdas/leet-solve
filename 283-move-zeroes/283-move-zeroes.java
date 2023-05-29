class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0) {
                // find next non zero
                int j = i + 1;
                while (j < n && nums[j] == 0) {
                    j++;
                }

                
                if (j < n) {
                    swap(nums, i, j);
                }
            }
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}