class Solution {
    public int evalRPN(String[] strs) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if (st.isEmpty() || !set.contains(s)) { // it's a number
                st.push(Integer.parseInt(s));
            } else if (set.contains(s)) { // its an operator
                // stack at least will have 2 elements
                int num2 = st.pop();
                int num1 = st.pop();
                // System.out.print("num1 : " + num1 + " ");
                // System.out.println("num2 : " + num2);
                if (s.equals("+")) {
                    st.push(num1 + num2);
                } else if (s.equals("-")) {
                    st.push(num1 - num2);
                } else if (s.equals("*")) {
                    st.push(num1*num2);
                } else {
                    st.push(num1/num2);
                }
            }
            // System.out.println(st.toString());
        }

        // stack has only one element which is our answer
        return st.peek();
    }
}