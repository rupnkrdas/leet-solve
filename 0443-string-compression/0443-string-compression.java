class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0; // for assigning

        // `i` for iterating
        int i = 0;
        while (i < n) {
            char ch = chars[i];
            int count = 0;

            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            chars[idx++] = ch;
            if (count > 1) {
                String s = Integer.toString(count);
                for (int j = 0; j < s.length(); j++) {
                    chars[idx++] = s.charAt(j);
                }
            }
        }

        return idx;
    }
}