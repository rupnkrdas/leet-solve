class Solution {
    public int maxProfit(int[] prices) {
        int[] arr = prices;
        int mini = arr[0];
        int maxi = 0;
        for (int i = 1; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i] - mini);
            mini = Math.min(mini, arr[i]);
        }
        
        return maxi;
    }
}