class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        
        while (s <= e) {
            int m = s + (e - s) / 2;
            
            if (target == nums[m]) {
                return m;
            } else if(target < nums[m]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        
        return -1;
    }
}