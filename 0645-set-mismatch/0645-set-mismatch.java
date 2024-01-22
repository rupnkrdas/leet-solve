class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[correctIndex] != nums[i]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }


        for (int idx = 0; idx < n; idx++) {
            if (nums[idx] != idx + 1) {
                return new int[] {nums[idx], idx + 1};
            }
        }
        
        return new int[]{-1, -1};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}