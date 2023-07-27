class Solution {
    private boolean isGood(int[] batteries, long mid, int n) {
        long sum = 0;
        for (int b : batteries) {
            sum += Math.min(b, mid);
        }

        return sum >= mid * n;
    }
    public long maxRunTime(int n, int[] batteries) {
        long start = Integer.MAX_VALUE;
        long end = 0;
        for (int b : batteries) {
            start = Math.min(start, b);
            end += b;
        }

        long ans = 0;
        while (start <= end) {
            long mid = start + (end - start)/2;
            if (isGood(batteries, mid, n)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return ans;
    }
}