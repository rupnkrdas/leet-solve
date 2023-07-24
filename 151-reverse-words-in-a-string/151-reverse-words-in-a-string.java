class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        List<String> list = new ArrayList<>();

        String str = "";
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            
            if (c == ' ') {
                if (!str.isEmpty()) {
                    list.add(str);
                }
                str = "";
            } else {
                str += c;
            }
        }

        if (!str.isEmpty()) {
            list.add(str);
        }

        String res = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            res += list.get(i) + " ";
        }

        return res.substring(0, res.length() - 1);
    }
}