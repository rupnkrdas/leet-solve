class Solution {
    public int maxScore(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int totalZeroes = 0;
        for (int i = 0; i < n; i++) totalZeroes += (arr[i] == '0') ? 1 : 0;
        int ones = 0;
        int zeroes = 0;
        int maxi = 0;
        for (int len = 1; len < n; len++) {
            zeroes += (arr[len - 1] == '0') ? 1 : 0;
            ones += (arr[len - 1] == '1') ? 1 : 0;
            
            maxi = Math.max(maxi, n - ones - (totalZeroes - zeroes));
        }

        return maxi;
    }
}