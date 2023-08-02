class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String s = countAndSay(n - 1);
        int i = 0;
        int len = s.length();
        int count = 0;

        String res = "";
        while (i < len) {
            char ch = s.charAt(i);
            while (i < len && s.charAt(i) == ch) {
                i++;
                count++;
            }

            res += Integer.toString(count) + ch;
            count = 0;
        }

        return res;
    }
}