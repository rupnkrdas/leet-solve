class Solution {
    private boolean isDigit(char ch) {
        return (ch - '0' >= 0 && ch - '0' <= 9);
    }
    public int calculate(String s) {
        int N = s.length();
        char[] arr = s.toCharArray();
        int num = 0;
        int result = 0;
        int sign = +1;

        Stack<Integer> st = new Stack<>();
        for (char ch : arr) {
            if (isDigit(ch)) {
                num = num*10 + (ch-'0');
            } else if (ch == '+') {
                result += num*sign;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                result += num*sign;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += num*sign;
                num = 0;
                int sign_ = st.pop();
                int result_ = st.pop();

                result *= sign_;
                result += result_;
            }
        }

        result += (num*sign);
        return result;
    }
}