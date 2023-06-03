class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = n; 
        int close = n;
        solve(n, n, "", ans);

        return ans;
    }

    public void solve(int open, int close, String s, List<String> ans) {
        if (open == 0 && close == 0) {
            ans.add(new String(s));
            return;
        }

        if (open != 0) {
            String s1 = s;
            s1 += '(';
            solve(open - 1, close, s1, ans);
        }
        
        if (close > open) {
            String s2 = s;
            s2 += ')';
            solve(open, close - 1, s2, ans);
        }

        return;
    }
}