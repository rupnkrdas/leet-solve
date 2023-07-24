class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        int N = nums.length;
        if (N == 1) {
            if (n == 0) return true;
            else return (nums[0] == 0 && n == 1);
        }
        for (int i = 0; i < N; i++) {
            if (i == 0 && i != N - 1) {
                if (nums[i + 1] == 0 && nums[i] == 0) {
                    nums[i] = 1;
                    n--;
                }
            } else if (i == N - 1 && i > 0) {
                if (nums[i - 1] == 0 && nums[i] == 0) {
                    nums[i] = 1;
                    n--;
                }
            } else {
                if (i + 1 < N && i - 1 >= 0) {
                    if (nums[i + 1] == 0 && nums[i - 1] == 0 && nums[i] == 0) {
                        nums[i] = 1;
                        n--;
                    }
                }
            }
        }

        return n <= 0;
    }
}