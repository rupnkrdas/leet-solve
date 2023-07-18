class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return count;
    }

    private void count_pairs(int[] nums, int start, int mid, int end) {
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && (long)nums[i] > 2 * (long)nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
    }
    
    // merge-sort
    private void sort(int[] nums, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start)/2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }
    
    private void merge(int[] nums, int start, int mid, int end) {
        List<Integer> temp = new ArrayList<>();
        int i = start;
        int j = mid + 1;
        
        count_pairs(nums, start, mid, end);

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp.add(nums[i++]);
            } else { 
                temp.add(nums[j++]);
            }
        }

        while (i <= mid) {
            temp.add(nums[i++]);
        }
        while (j <= end) {
            temp.add(nums[j++]);
        }

        // transfer elements from temp to nums
        for (int k = start; k <= end; k++) {
            nums[k] = temp.get(k - start);
        }
    }
}