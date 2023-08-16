class Solution {
    private boolean isGood(int[] nums, int k, long mid) {
        long sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                count++;
                sum = num;
            }
        }

        if (sum > 0) {
            count++;
        }

        return count <= k;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        long end = 0;
        long start = Integer.MIN_VALUE;
        for (int num : nums) {
            start = Math.max(start, num);
            end += (long)(num);
        }

        long ans = end;
        while (start <= end) {
            long mid = start + (end - start)/2;
            // System.out.println(mid); 

            if (isGood(nums, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (int)ans;
    }
}