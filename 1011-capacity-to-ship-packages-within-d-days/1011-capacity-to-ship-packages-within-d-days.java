class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 1;
        int end = sum(weights);

        int res = end;
        while (start <= end) {
            int mid = start + (end-start)/2;

            if (possible(mid, days, weights)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }
    
    public int sum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        return sum;
    }

    public boolean possible(int cap, int days, int[] weights) {
        int ships = 1;
        int currCap = cap;
        for (int w : weights) {
            if (cap < w) {
                return false;
            }
            if (currCap - w < 0) {
                ships++;
                currCap = cap;
            }
            currCap -= w;
        }

        return ships <= days;
    }
} 