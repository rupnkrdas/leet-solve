class Solution {
    public String removeStars(String s) {
        char[] str = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (st.isEmpty() || c != '*') {
                st.push(c);
            } else {
                st.pop();
            }
        }

        String res = "";
        while (!st.isEmpty()) {
            res = st.pop() + res;
        }

        return res;
    }
}