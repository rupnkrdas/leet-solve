class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        nums = removeDuplicates(nums);
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int maxi = 1;
        int temp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                maxi = Math.max(maxi, maxi + 1);
            } else {
                temp = Math.max(temp, maxi);
                maxi = 1;
            }
        }   

        return Math.max(temp, maxi);
    }

    public int[] removeDuplicates(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }

        int[] ans = new int[map.size()];
        int i = 0;
        for (int num : map.keySet()) {
            ans[i] = num;
            i++;
        }

        return ans;
    }
}