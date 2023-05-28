class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        LinkedList<Integer> l = new LinkedList<>();
        
        int i = 0;
        int j = 0;
        while (j < n) {
            // calculation
            while (l.size() > 0 && l.peekLast() < nums[j]) {
                l.removeLast();
            }
            l.addLast(nums[j]);
            
            // expand window
            if (j - i + 1 < k) {
                j++;
            }
            
            // window size hit
            else if (j - i + 1 == k) {
                // add calculation to ans
                int maxi = l.peekFirst();
                ans.add(maxi);

                // slide the window
                if (nums[i] == maxi) {
                    l.removeFirst();
                }
                i++;
                j++;
            }
        }
        
        int[] res = new int[n - k + 1];
        for (int a = 0; a < n - k + 1; a++) {
            res[a] = ans.get(a);
        }
        
        return res;
    }
}