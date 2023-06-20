class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { firstOcurrence(nums, target), lastOcurrence(nums, target) };
        return ans;
    }
    
    // return the index of first occurence
    int firstOcurrence(int[] nums, int target) {
        int firstOccurence = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                firstOccurence = mid;
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return firstOccurence;
    }

    // return the index of last occurence
    int lastOcurrence(int[] nums, int target) {
        int lastOcurrence = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                lastOcurrence = mid;
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return lastOcurrence;
    }
}