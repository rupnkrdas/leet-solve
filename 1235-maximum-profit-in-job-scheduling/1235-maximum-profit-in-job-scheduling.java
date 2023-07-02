class Solution {
    int[] dp = new int[(int)(5e4 + 1)];
    public int find_next(List<int[]> tasks, int start, int currentTaskEnd) {
        int end = tasks.size() - 1;
        int ans = end + 1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (tasks.get(mid)[0] >= currentTaskEnd) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
    public int f(int index, List<int[]> tasks) {
        if (index == tasks.size()) {
            return 0;
        }
        
        if (dp[index] != -1) return dp[index];

        //take
        int next = find_next(tasks, index + 1, tasks.get(index)[1]);
        int take = tasks.get(index)[2] + f(next, tasks);
        int notTake = f(index + 1, tasks);

        return dp[index] = Math.max(take, notTake);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        List<int[]> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = startTime[i];
            int end = endTime[i];
            int p = profit[i];

            tasks.add(new int[]{start, end, p});
        }
        
        Arrays.fill(dp, -1);

        Collections.sort(tasks, (t1, t2) -> (t1[0]-t2[0]));
        return f(0, tasks);
    }
}