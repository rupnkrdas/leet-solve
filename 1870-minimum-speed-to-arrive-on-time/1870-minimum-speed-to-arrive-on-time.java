class Solution {
    private boolean isGood(int[] dist, double hour, int speed) {
        double total_time = 0;
        int n = dist.length;
        for (int i = 0; i < n - 1; i++) {
            total_time += Math.ceil((double)dist[i]/speed);
        }
        total_time += (double)dist[n - 1]/speed;

        return total_time <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        // range of possible speeds
        int start = 1;
        int end = (int)(1e7);

        int ans = -1;
        while (start <= end) {
            int speed = start + (end - start)/2;

            if (isGood(dist, hour, speed)) {
                ans = speed;
                end = speed - 1;
            } else {
                start = speed + 1;
            }
        }

        return ans;
    }
}