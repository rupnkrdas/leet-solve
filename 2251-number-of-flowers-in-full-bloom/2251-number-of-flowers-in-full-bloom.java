class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int p : people) {
            map.put(p, 0);
        }
        for (int[] f : flowers) {
            map.put(f[0], map.getOrDefault(f[0], 0) + 1);
            map.put(f[1] + 1, map.getOrDefault(f[1] + 1, 0) - 1);
        }
        
        int ct = 0;
        for (int key : map.keySet()) {
            ct += map.get(key);
            map.put(key, ct);
        }

        int[] ans = new int[people.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(people[i]);
        }

        return ans;
    }
}