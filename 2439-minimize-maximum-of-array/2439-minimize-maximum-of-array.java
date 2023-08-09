class Solution {
    private boolean isGood(int[] nums, int mid) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > mid) return false;
            long buffer = mid - arr[i];
            arr[i + 1] -= buffer;
        }

        return arr[n - 1] <= mid;
    }
    public int minimizeArrayValue(int[] nums) {
        int start = 0;
        int end = Arrays.stream(nums).max().getAsInt();

        int ans = end;
        while (start <= end) {
            int mid = start + (end - start)/2;

            if (isGood(nums, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}