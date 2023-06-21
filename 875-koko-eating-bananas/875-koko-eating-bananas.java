class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int start = 1;
        int end = max(arr);

        int res = end;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (canEat(arr, mid, h)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

    public int max(int[] arr) {
        int maxi = arr[0];
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        return maxi;
    }

    public boolean canEat(int[] arr, int speed, int h) {
        long time = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % speed == 0) {
                time += (long)arr[i]/(long)speed;
            } else {
                time += ((long)arr[i] + (long)(speed - (arr[i]%speed)))/(long)speed;
            }
        }

        return time <= h;
    }












}