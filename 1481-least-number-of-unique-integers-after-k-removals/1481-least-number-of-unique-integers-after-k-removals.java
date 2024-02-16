class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();

            list.add(new int[]{key, val});
        }

        Collections.sort(list, (a, b) -> a[1]-b[1]);
        for (int i = 0; i < list.size(); i++) {
            while (list.get(i)[1] > 0 && k > 0) {
                list.get(i)[1]--;
                k--;
            }
        }

        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            ans += (list.get(i)[1] > 0) ? 1 : 0;
        }

        return ans;
    }
}