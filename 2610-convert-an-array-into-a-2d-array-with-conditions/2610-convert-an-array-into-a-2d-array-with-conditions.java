class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // each row -> distinct integers 
        // min number of rows
        // rows : max frequency among the integers in nums

        Map<Integer, Integer> map = new HashMap<>();
        int maxi = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxi = Math.max(maxi, map.get(num));
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < maxi; i++) list.add(new ArrayList<>());

        for (int key : map.keySet()) {
            int val = map.get(key);
            for (int i = 0; i < val; i++) {
                list.get(i).add(key);
            }
        }

        return list;
    }
}