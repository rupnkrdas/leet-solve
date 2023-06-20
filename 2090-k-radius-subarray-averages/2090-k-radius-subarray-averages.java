class Solution {
    public int[] getAverages(int[] nums, int k) {
        return f(nums, k);
    }

    public int[] f(int[] nums, int k) {
        int n = nums.length;
        int window = 2*k + 1;
        int i = 0;
        int j = 0;
        long sum = 0;

        int index = k;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        while (j < n) {
            sum += (long)nums[j];

            if (j - i + 1 < window) {
                j++;
            } else if (j - i + 1 == window) {
                if (index < n) {
                    ans[index] = (int)(sum/window);
                }
                index++;
                sum -= nums[i];
                i++;
                j++;
                if (index > n - k) return ans;
            }
        }

        return ans;
    }
}