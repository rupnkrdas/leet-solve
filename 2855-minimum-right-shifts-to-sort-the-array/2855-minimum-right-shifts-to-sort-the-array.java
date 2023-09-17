class Solution {
    private int findPivot(List<Integer> nums, int n) {
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int mid = start + (end - start)/2;

            if (nums.get(mid) > nums.get(end)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        int pivot = findPivot(nums, n);
        List<Integer> left = nums.subList(0, pivot);
        List<Integer> right = nums.subList(pivot, n);

        // System.out.println(left);
        // System.out.println(right);

        int maxi = (left.size() > 0) ? left.get(0) : Integer.MAX_VALUE;
        for (int i = 1; i < left.size(); i++) {
            if (left.get(i) < left.get(i - 1)) return -1;
            maxi = Math.max(maxi, left.get(i));
        }

        
        for (int i = 1; i < right.size(); i++) {
            if (right.get(i) < right.get(i - 1) || right.get(i) > maxi) return -1;
        }

        if (pivot == 0) return 0;
        return n - pivot;
    }
}