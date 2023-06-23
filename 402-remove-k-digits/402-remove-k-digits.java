class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) return "0";
        char[] arr = num.toCharArray();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int number = arr[i] - '0';
            if (st.isEmpty()) {
                st.push(number);
            } else {
                if ((arr[i] - '0') > st.peek()) {
                    st.push(number);
                } else {
                    while (!st.isEmpty() && k > 0 && number < st.peek()) {
                        st.pop();
                        k--;
                    } 
                    st.push(number);
                }
            }
        }

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }
        
        String res = "";
        while (!st.isEmpty()) {
            res = Integer.toString(st.pop()) + res;
        }

        // remove leading zeroes;
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }

        return (i == res.length()) ? "0" : res.substring(i, res.length());
    }
}