class Solution {
    public int mySqrt(int x) {
        return (int)binarySearch(x);
    }
    
    long binarySearch(int n) {
        long res = 0;
        long start = 1;
        long end = n;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            
            if (mid*mid == n) {
                return mid;
            } else if (n < mid*mid) {
                end = mid - 1;
            } else {
                res = mid;
                start = mid + 1;
            }
        }
        
        return res;
    }
}