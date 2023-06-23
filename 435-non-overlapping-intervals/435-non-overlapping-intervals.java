class Solution {
    public int eraseOverlapIntervals(int[][] it) {
        Arrays.sort(it, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int ans = a[1] - b[1];
                return (ans != 0) ? ans : a[0] - b[0];
            }
        });

        int count = 0;
        int n = it.length;
        int[] pair = {it[0][0], it[0][1]};
        for (int i = 1; i < n; i++) {
            if (it[i][0] < pair[1]) {
                count++;
            } else {
                pair[0] = it[i][0];
                pair[1] = it[i][1];
            }
        }

        return count;
    }
}