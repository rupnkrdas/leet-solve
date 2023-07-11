class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
            
            int n1 = nums[i];
            int target = -n1;
            
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    if (j + 1 < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    else if (k - 1 > j && nums[k - 1] == nums[k]) {
                        k--;
                    } else {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(n1);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        ans.add(triplet);
                        j++;
                        k--;
                    }
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }
}