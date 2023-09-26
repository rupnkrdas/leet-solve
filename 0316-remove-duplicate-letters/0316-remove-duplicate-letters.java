class Solution {
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] used = new int[26];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = n - 1; i >= 0; i--) {
            if (last[arr[i]- 'a'] == -1) {
                last[arr[i] - 'a'] = i;
            }
        }

        // System.out.println(Arrays.toString(last));  

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = arr[i];

            if (st.isEmpty()) {
                st.push(c);
                used[c-'a'] = 1;
            } else {
                while (!st.isEmpty() && c < st.peek() && last[st.peek()-'a'] > i && used[st.peek()-'a'] == 1 && used[c-'a'] == 0) {
                    used[st.peek()-'a'] = 0;
                    st.pop();
                }
                if (used[c-'a'] == 0) {
                    st.push(c);
                    used[c-'a']=1;
                }
            }

            // System.out.println(st.toString());
        }

        String ans = "";
        while (!st.isEmpty()) {
            ans = st.pop() + ans;
        }

        return ans;
    }
}