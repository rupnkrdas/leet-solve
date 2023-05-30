class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] row1, int[] row2) {
                return row1[0] - row2[0];
            }
        });

        int[] p = new int[]{arr[0][0], arr[0][1]};
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (arr[i][0] <= p[1]) {
                p[1] = Math.max(arr[i][1], p[1]);
            } else {
                list.add(new int[]{p[0], p[1]});
                p[0] = arr[i][0];
                p[1] = arr[i][1];
            }
        }
        list.add(new int[]{p[0], p[1]});

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }

        return ans;
    }
}