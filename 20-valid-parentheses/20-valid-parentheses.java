class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = str[i];

            if (st.isEmpty() || c == '(' || c == '[' || c == '{') st.push(c);
            


            if (c == ')') {
                if (st.peek() == '(') st.pop();
                else return false;
            }
            else if (c == ']') {
                if (st.peek() == '[') st.pop();
                else return false;
            }
            else if (c == '}') {
                if (st.peek() == '{') st.pop();
                else return false;
            }
        }

        return st.isEmpty();
    }
}