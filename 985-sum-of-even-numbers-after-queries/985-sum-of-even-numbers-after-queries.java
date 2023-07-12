class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>(); // (index) -> nums[index];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
            sum += (nums[i] % 2 == 0) ? nums[i] : 0;
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int val     = q[0];
            int index   = q[1];

            if (map.get(index) % 2 == 0) {
                if (val % 2 == 0) {
                    sum -= map.get(index);
                    map.put(index, map.get(index) + val);
                    sum += map.get(index);
                } else {
                    sum -= map.get(index);
                    map.put(index, map.get(index) + val);
                }
            } else {
                if (val % 2 != 0) {
                    map.put(index, map.get(index) + val);
                    sum += map.get(index);
                } else {
                    map.put(index, map.get(index) + val);
                }
            }

            ans[i++] = sum;
        }

        return ans;
    }
}