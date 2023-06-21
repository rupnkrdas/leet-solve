class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            return bs(nums, 0, nums.length - 1, target);
        } else {
            int ans = bs(nums, 0, pivot, target);
            return (ans != -1) ? ans : bs(nums, pivot + 1, nums.length - 1, target);
        }
    }

    public int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid + 1 <= end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid - 1 >= start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int bs(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}