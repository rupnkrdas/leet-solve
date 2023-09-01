class Solution {
    int N;
    Map<String, Integer> dp = new HashMap<>();
    private int f(int idx, List<int[]> list) {
        if (list.get(idx)[1] == N) return 1;
        if (idx >= list.size()) return (int)1e8;

        String key = Integer.toString(idx);
        if (dp.containsKey(key)) return dp.get(key);

        int ans = (int)1e8;
        for (int j = idx + 1; j < list.size(); j++) {
            if (list.get(j)[0] > list.get(idx)[1]) break;
            ans = Math.min(ans, 1 + f(j, list));
        }

        dp.put(key, ans);
        return ans;
    }
    public int minTaps(int n, int[] ranges) {
        N = n;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            list.add(new int[]{Math.max(0, i-ranges[i]), Math.min(n, i+ranges[i])});
        }

        Collections.sort(list, (p1, p2) -> p1[0]-p2[0]);

        for (int[] num : list) {
            System.out.print(Arrays.toString(num) + " ");
        }


        int count = 0;
        int end = 0;
        int ans = (int)1e8;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == 0) {
                ans = Math.min(ans, f(i, list));
            }
        }

        if (ans >= (int)(1e8)) return -1;
        return ans;
    }
}
