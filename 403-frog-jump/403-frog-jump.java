class Solution {
    Map<String, Boolean> dp = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<>();
    public boolean canCross(int[] stones) {
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        return f(0, stones, 1);
    }

    public boolean f(int index, int[] stones, int lastJump) {
        if (index == stones.length - 1) return true;
        if (index >= stones.length) return false;

        String key = Integer.toString(index) + "," + Integer.toString(lastJump);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        
        boolean kMinus1 = false;
        // k-1 jump
        int op1 = lastJump - 1;
        if (op1 >= 1 && map.containsKey(stones[index] + op1)) {
            kMinus1 = f(map.get(stones[index] + op1), stones, op1);
        }
        // k jump
        boolean k = false;
        int op2 = lastJump;
        if (op2 >= 1 && map.containsKey(stones[index] + op2)) {
            k = f(map.get(stones[index] + op2), stones, op2);
        }
        // k+1 jump
        boolean kPlus1 = false;
        if (index >= 1) {
            int op3 = lastJump + 1;
            if (op3 >= 1 && map.containsKey(stones[index] + op3)) {
                kPlus1 = f(map.get(stones[index] + op3), stones, op3);
            }
        }


        boolean ans = kMinus1 || k || kPlus1;
        dp.put(key, ans);
        return ans;
    }
}