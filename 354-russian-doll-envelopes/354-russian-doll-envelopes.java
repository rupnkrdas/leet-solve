class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                int val = p1[0]-p2[0];
                return (val != 0) ? val : p2[1]-p1[1];
            }
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 0;

        for (int[] env : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, env[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = env[1];
            if (index == len) len++;
        }
        
        return len;
    }
}