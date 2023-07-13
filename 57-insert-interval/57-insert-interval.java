class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int[] pair = new int[]{ newInterval[0], newInterval[1]};
        for (int i = 0; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (e < pair[0]) {
                list.add(new int[]{s, e});
            } else if (s > pair[1]) {
                list.add(new int[]{pair[0], pair[1]});
                pair[0] = s;
                pair[1] = e;
            } else {
                pair[0] = Math.min(pair[0], s);
                pair[1] = Math.max(pair[1], e);
            }
        }
        list.add(new int[]{pair[0], pair[1]});

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }

        return ans;
    }
}