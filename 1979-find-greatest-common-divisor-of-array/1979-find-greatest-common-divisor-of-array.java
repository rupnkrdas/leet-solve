class Solution {
    public int findGCD(int[] nums) {
        int maxi = nums[0];
        int mini = nums[0];

        for (int num : nums) {
            maxi = Math.max(maxi, num);
            mini = Math.min(mini, num);
        }

        return gcd(mini, maxi);
    }

    private int gcd(int a, int b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }
}