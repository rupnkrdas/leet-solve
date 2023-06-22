class Solution {
    String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        f(0, "", digits, ans);
        return ans;
    }

    public void f(int idx, String s, String digits, List<String> ans) {
        if (idx == digits.length()) {
            if (!s.isEmpty()) {
                ans.add(new String(s));
            }
            return;
        }

        for (int i = 0; i < map[digits.charAt(idx)-'0'].length(); i++) {
            char c = map[digits.charAt(idx)-'0'].charAt(i);
            s += c;
            f(idx + 1, s, digits, ans);
            s = s.substring(0, s.length() - 1);
        }
    }
}