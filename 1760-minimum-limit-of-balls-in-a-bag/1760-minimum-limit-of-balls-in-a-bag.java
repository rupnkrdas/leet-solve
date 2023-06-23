class Solution {
    int MO;
    public int max(int[] nums) {
        int maxi = nums[0];
        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }

        return maxi;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        MO = maxOperations;
        int start = 1;
        int end = max(nums);
        int mini = end;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if(canTake(nums, mid)) {
                mini = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return mini;
    }

    public boolean canTake(int[] nums, int penalty) {
        int n = nums.length;
        int cost = 0;
        for (int i = 0; i < n; i++) {
            cost += Math.ceil((double)nums[i]/(double)penalty) - 1;
        }

        return cost <= MO;
    }
}