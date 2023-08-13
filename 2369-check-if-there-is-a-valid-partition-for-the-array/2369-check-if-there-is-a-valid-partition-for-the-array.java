class Solution {
    int[] dp = new int[(int)(1e5 + 1)];
    private boolean isIncreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) != 1) return false;
        }

        return true;
    }
    private boolean f(int idx, int[] nums) {
        if (idx == nums.length) return true;

        if (dp[idx] != -1) {
            return (dp[idx]==1)?true:false;
        }
        
        Set<Integer> set = new HashSet<>();
        boolean ans = false;
        boolean flag = true;
        for (int i = idx; i < Math.min(idx+3,nums.length); i++) {
            set.add(nums[i]);
            int len = i - idx + 1;
            if (i > idx) {
                if (nums[i]-nums[i-1] != 1) flag = false;
            }
            if (len == 3) {
                if (set.size() == 1) {
                    if (f(i + 1, nums)) {
                        ans = true;
                        break;
                    }
                } else {
                    if (flag) {
                        // System.out.println(set.toString());
                        // List list = new ArrayList<>();
                        // list.addAll(set);
                        // if (isIncreasing(list)) {
                        //     ans = true;
                        //     break;
                        // }
                        if (f(i+1, nums)) {
                            ans = true;
                            break;
                        }
                    }
                }
            } else if (len == 2) {
                if (set.size() == 1) {
                    if (f(i+1, nums)) {
                        ans = true;
                        break;
                    }
                }
            }
        }

        dp[idx] = ans?1:0;
        return ans;
    }
    public boolean validPartition(int[] nums) {
        Arrays.fill(dp, -1);
        return f(0, nums);
    }
}