class Solution {
    public int compress(char[] chars) {
        char ch = chars[0];
        int count = 1;

        int n = chars.length;
        String s = "";

        for (int i = 1; i < n; i++) {
            char c = chars[i];
            // System.out.println("ch : " + ch + " count : " + count);
            if (c == ch) {
                count++;
            }
            else {
                s += ch;
                if (count > 1) {
                    s += Integer.toString(count);
                }

                ch = c;
                count = 1;
            }
        }

        s += ch + ((count>1)?Integer.toString(count):"");
        // System.out.println(s);

        for (int i = 0; i < s.length(); i++) {
            // System.out.println("i : " + i + " s.charAt(i) : " + s.charAt(i));
            chars[i] = s.charAt(i);
            // System.out.println(Arrays.toString(chars));
        }

        return s.length();
    }
}