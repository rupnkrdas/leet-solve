class Solution {
    public String makeGood(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();

        for (char c : arr) {
            if (st.isEmpty()) st.push(c);
            else {
                if (Math.abs(c - st.peek()) == 32) {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
        }

        String ans = "";
        while (!st.isEmpty()) {
            ans = st.pop() + ans;
        }

        return ans;
    }
}