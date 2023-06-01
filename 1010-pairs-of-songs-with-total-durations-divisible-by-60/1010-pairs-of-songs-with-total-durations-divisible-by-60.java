class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int need = 60 - (time[i] % 60);
            if (need == 60) {
                need = 0;
            }
            if (map.containsKey(need)) {
                count += map.get(need);
            }

            int key = time[i] % 60;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }
}