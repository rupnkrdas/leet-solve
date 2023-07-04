class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = str[i];
            if (st.isEmpty()) st.push(c);
            else {
                if (st.peek() != c) st.push(c);
                else st.pop();
            }
        }

        String res = "";
        while (!st.isEmpty()) {
            res = st.pop() + res;
        }

        return res;
    }
}