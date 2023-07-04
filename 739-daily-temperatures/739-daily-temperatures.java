class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ngr = f(temp);
        int[] ans = new int[temp.length];
        for (int i = 0; i < n; i++) {
            ans[i] = (ngr[i] != n) ? (ngr[i] - i) : 0;
        }
        
        return ans;
    }

    public int[] f(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                if (nums[st.peek()] > nums[i]) {
                    ans[i] = st.peek();
                } else {
                    while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                        st.pop();
                    }
                    if (st.isEmpty()) {
                        ans[i] = n;
                    } else {
                        ans[i] = st.peek();
                    }
                }
            }

            st.push(i);
        }

        return ans;
    }
}