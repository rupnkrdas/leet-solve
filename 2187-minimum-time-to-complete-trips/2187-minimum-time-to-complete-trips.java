class Solution {
    private boolean isGood(long mid, int[] time, int tt) {
        long sum = 0;
        for (int t : time) {
            sum += (mid/t);
            if (sum >= tt) return true;
        }

        return sum >= tt;
    }
    public long minimumTime(int[] time, int tt) {
        long start = 1;
        long end = 0;
        for (int t : time) {
            end = Math.max(end, t);
        }
        end *= tt;

        long ans = end;
        while (start <= end) {
            long mid = start + (end - start)/2;

            if (isGood(mid, time, tt)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}