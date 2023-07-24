class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        String res = "";
        String str = "";
        for (int i = n - 1; i >= 0; i--) {
            char c = arr[i];
            
            if (c == ' ') {
                if (!str.isEmpty()) {
                    res += str + " ";
                }
                str = "";
            } else {
                str = c + str;
            }
        }

        if (!str.isEmpty()) {
            res += str + " ";
        }

        // System.out.println("'" + res + "'");
        return res.substring(0, res.length() - 1);
    }
}