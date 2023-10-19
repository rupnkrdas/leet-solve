class Solution {
    private String f(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();

        for (char c : arr) {
            if (st.isEmpty()) {
                if (c != '#') st.push(c);
            } else {
                if (c == '#') st.pop();
                else st.push(c);
            }
        }

        String res = "";
        while (!st.isEmpty()) {
            res = st.pop() + res;
        }

        return res;
    }
    public boolean backspaceCompare(String s, String t) {
        return f(s).equals(f(t));
    }
}