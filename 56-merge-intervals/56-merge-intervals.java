class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        int[] pair = {intervals[0][0], intervals[0][1]};
        
        List<int[]> list = new ArrayList<>();
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > pair[1]) { // cannot be merged
                list.add(new int[]{pair[0], pair[1]});
                pair[0] = intervals[i][0];
                pair[1] = intervals[i][1];
            } else { // merge
                pair[0] = Math.min(pair[0], intervals[i][0]);
                pair[1] = Math.max(pair[1], intervals[i][1]);
            }
        }
        list.add(new int[] {pair[0], pair[1]});

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }

        return ans;
    }
}