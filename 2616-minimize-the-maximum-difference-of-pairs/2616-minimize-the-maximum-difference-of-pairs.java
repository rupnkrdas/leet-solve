class Solution {
    private boolean isGood(int[] nums, int p, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) <= diff) {
                count++;
                i++;
            }
        }

        return (count >= p);
    }
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);

        int start = 0;
        int end = nums[n - 1] - nums[0];

        int ans = end;
        while (start <= end) {
            int mid = start + (end - start)/2;

            if (isGood(nums, p, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}