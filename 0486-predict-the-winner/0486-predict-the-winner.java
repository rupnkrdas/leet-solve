class Solution {
    Map<String, Integer> map = new HashMap<>();
    private int solve_for_1(int i, int j, int[] nums, int turn) {
        if (i == j) return nums[i];
        if (i > j) return 0;

        String key = Integer.toString(i) + Integer.toString(j) + Integer.toString(turn);
        if (map.containsKey(key)) return map.get(key);
        
        if (turn == 0) {
            int take_i = nums[i] + solve_for_1(i + 1, j, nums, 1 - turn);
            int take_j = nums[j] + solve_for_1(i, j - 1, nums, 1 - turn);
            int ans = Math.max(take_i, take_j);
            map.put(key, ans);
            return ans;
        } else { 
            // player 2 turn but we are solving for player 1
            // its not player1's turn, therefore, we can't take the `value` and expect the worst from player2
            // yeh wala `value` player2 ne uthaya hoga, we are only about player1 here
            int take_i = solve_for_1(i + 1, j, nums, 1 - turn);
            int take_j = solve_for_1(i, j - 1, nums, 1 - turn);
            int ans = Math.min(take_i, take_j);
            map.put(key, ans);
            return ans;
        }
    }
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int player1 = solve_for_1(0, n - 1, nums, 0);
        int player2 = Arrays.stream(nums).sum() - player1;

        return player1 >= player2;
    }
}