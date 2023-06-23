class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // (nums[i] -> index) for nums2
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] ngr = ngr(nums2);
        System.out.println(Arrays.toString(ngr));
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            int index = map.get(num);
            ans[i] = ngr[index];
        }

        return ans;
    }

    public int[] ngr(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                if (st.peek() > arr[i]) {
                    ans[i] = st.peek();
                } else {
                    while (!st.isEmpty() && st.peek() <= arr[i]) {
                        st.pop();
                    }
                    if (st.isEmpty()) {
                        ans[i] = -1;
                    } else {
                        ans[i] = st.peek();
                    }
                }
            }

            st.push(arr[i]);
        }

        return ans;
    }
}