class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // applying algo similar to Moore's Voting Algorithm
        int el1 = -1;
        int el2 = -1;
        int count1 = 0;
        int count2 = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != el2) {
                el1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && nums[i] != el1) {
                el2 = nums[i];
                count2 = 1;
            } else if (nums[i] == el1) count1++;
            else if (nums[i] == el2) count2++;
            else {
                count1--;
                count2--;
            }
        }

        int target = (int)Math.floor((double)n / 3);
        int freq1 = 0;
        int freq2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) freq1++;
            else if (nums[i] == el2) freq2++;
        }

        List<Integer> ans = new ArrayList<>();
        if (freq1 > target) ans.add(el1);
        if (freq2 > target) ans.add(el2);

        return ans;
    }
}