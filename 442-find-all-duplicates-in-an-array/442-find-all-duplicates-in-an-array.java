class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    public void sort(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correct_index = nums[i] - 1;
            if (nums[correct_index] != nums[i]) {
                swap(nums, i, correct_index);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 