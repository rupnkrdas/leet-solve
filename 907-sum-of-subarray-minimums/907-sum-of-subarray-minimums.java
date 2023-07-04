class Solution {
    private int MOD = (int)(1e9 + 7);
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nsr = get_nsr(arr);
        int[] nsl = get_nsl(arr);
        // System.out.println(Arrays.toString(nsl));
        // System.out.println(Arrays.toString(nsr));

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long nums_on_left = i - nsl[i];
            long nums_on_right = nsr[i] - i;
            long nums_with_element_as_smallest = (nums_on_left) * (nums_on_right);

            sum = sum%MOD + (nums_with_element_as_smallest*arr[i])%MOD;
        }

        return (int)sum%MOD;
    }
    public int[] get_nsr(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                    st.pop();
                }
                ans[i] = st.isEmpty() ? n : st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int[] get_nsl(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(st.isEmpty()) {
                ans[i] = -1;
            } else {
                while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                    st.pop();
                }
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(i);
        }

        return ans;
    }
}