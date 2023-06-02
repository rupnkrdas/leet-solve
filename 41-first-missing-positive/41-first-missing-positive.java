class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        swapSort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public void swapSort(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (correctIndex < 0 || correctIndex >= n) {
                i++;
            }
            else if (nums[correctIndex] != nums[i]) {
                swap(nums, correctIndex, i);
            }
            else {
                i++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}