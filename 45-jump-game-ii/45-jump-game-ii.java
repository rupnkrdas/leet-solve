class Solution {
    public int jump(int[] nums) {
        return f(nums);
    }

    public int f(int[] arr) {
        int[] dp = new int[(int)1e4 + 1];
        
        for (int index = arr.length - 1; index >= 0; index--) {
            if (index == arr.length - 1) {
                dp[index] = 0;
                continue;
            }
            if (index >= arr.length) {
                dp[index] = (int)1e9;
                continue;
            }

            int jumps = (int)1e9;
            for (int i = 1; i <= arr[index]; i++) {
                int nextIndex = index + i;
                nextIndex = Math.min((int)1e4, nextIndex);
                int jmp = 1 + dp[nextIndex];
                jumps = Math.min(jmp, jumps);
            }

            dp[index] = jumps;
        }

        return dp[0];
    }
}