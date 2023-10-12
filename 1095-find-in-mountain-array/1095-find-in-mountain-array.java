/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    private int findPeak(MountainArray arr) {
        int N = arr.length();
        int start = 0, end = N - 1;

        while (start < end) {
            int mid = start + (end - start)/2;

            if (arr.get(mid) < arr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
    private int bs(MountainArray arr, int start, int end, int target) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr.get(mid) == target) {
                ans = mid;
                end = mid - 1;
            } else if (target > arr.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
    private int bs_(MountainArray arr, int start, int end, int target) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr.get(mid) == target) {
                ans = mid;
                end = mid - 1;
            } else if (target < arr.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
    public int findInMountainArray(int target, MountainArray arr) {
        int peak = findPeak(arr);
        int left = bs(arr, 0, peak, target);
        return (left != -1) ? left : bs_(arr, peak + 1, arr.length() - 1, target);
    }
}