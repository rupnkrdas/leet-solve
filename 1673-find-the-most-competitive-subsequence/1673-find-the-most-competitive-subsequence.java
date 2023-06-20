class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int toRemove = nums.length - k; // elements remaining to remove
        for (int num : nums) {
            if (st.isEmpty()) {
                st.push(num);
            } else {
                if (num >= st.peek()) {
                    st.push(num);
                } else {
                    while (!st.isEmpty() && toRemove > 0 && num < st.peek()) {
                        st.pop();
                        toRemove--;
                    }
                    st.push(num);
                }
            }
        }

        while (!st.isEmpty() && toRemove > 0) {
            st.pop();
            toRemove--;
        }

        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}