class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsl = findNSL(heights);
        int[] nsr = findNSR(heights);

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int area = (nsr[i] - nsl[i] - 1) * heights[i];
            maxi = Math.max(maxi, area);
        }


        return maxi;
    }

    public int[] findNSR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                if (arr[st.peek()] < arr[i]) {
                    ans[i] = st.peek();
                } else {
                    while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
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
    
    public int[] findNSL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                if (arr[st.peek()] < arr[i]) {
                    ans[i] = st.peek();
                } else {
                    while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                        st.pop();
                    }
                    if (st.isEmpty()) {
                        ans[i] = -1;
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