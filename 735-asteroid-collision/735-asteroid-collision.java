class Solution {
    public void f(Stack<Integer> st, int ast) {
        while (!st.isEmpty() && st.peek() > 0) {
            if (st.peek() > -ast) {
                return;
            } else if (st.peek() == -ast) {
                st.pop();
                return;
            } else {
                st.pop();
            }
        }

        st.push(ast);
        return;
    }
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int ast = asteroids[i];
            if (st.isEmpty() || ast > 0) st.push(ast);
            else {
                f(st, ast);
            }
        }

        
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}