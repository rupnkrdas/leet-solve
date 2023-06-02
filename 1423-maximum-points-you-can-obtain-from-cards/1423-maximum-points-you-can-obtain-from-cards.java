class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] arr = cardPoints;
        int n = arr.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        
        if (n == k) return total;

        int i = 0;
        int j = 0;
        int mini = Integer.MAX_VALUE;
        int sum = 0;
        int K = n - k; // our window size;
        while (j < n) {
            // calculation
            sum += arr[j];

            // expand the window
            if (j - i + 1 < K) {
                j++;
            }

            // window size hit
            else if (j - i + 1 == K) {
                // add calculations to the ans
                mini = Math.min(mini, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }

        return total - mini;
    }
}