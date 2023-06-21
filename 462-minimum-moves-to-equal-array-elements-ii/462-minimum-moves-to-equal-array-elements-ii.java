class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int minMoves2(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        Pair pair = find(nums);
        int start = pair.first;
        int end = pair.second;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int ops1 = findOp(nums, mid);
            int ops2 = findOp(nums, mid + 1);

            ans = Math.min(ops1, ops2);

            if (ops2 > ops1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
    
    public int findOp(int[] nums, int target) {
        int ops = 0;
        for (int i = 0; i < nums.length; i++) {
            ops += Math.abs(nums[i] - target);
        }

        return ops;
    }

    public Pair find(int[] nums) {
        int n = nums.length;
        int mini = nums[0];
        int maxi = nums[0];
        for (int i = 1; i < n; i++) {
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }

        return new Pair(mini, maxi);
    }
}