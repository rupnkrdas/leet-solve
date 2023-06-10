class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long emptyRight = n - index - 1;
        long emptyLeft = index;

        long hi = maxSum, lo = 1, res = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            long el = mid - 1;

            long leftSum = 0, rightSum = 0, sum = 0;

            if (emptyRight <= el) {
                rightSum = (el*(el+1))/2 - ((el - emptyRight)*(el - emptyRight + 1)/2);
            } else {
                rightSum = (el*(el+1))/2 + (emptyRight - el);
            }

            if(emptyLeft <= el) {
                leftSum = (el*(el+1))/2 - ((el-emptyLeft)*(el-emptyLeft+1))/2;
            } else {
                leftSum = (el*(el+1))/2 + (emptyLeft - el);
            }

            sum = leftSum + mid + rightSum;
            if (sum <= maxSum) {
                lo = mid + 1;
                res = mid;
            } else {
                hi = mid - 1;
            }
        }
        return (int)res;
    }
}