class Solution {
    private boolean containsLeadingZeroes(String s) {
        return (s.length() > 1 && s.charAt(0) == '0');
    }
    List<String> ans = new ArrayList<>();
    private void f(int idx, String s, String temp, int count) {
        if (idx == s.length()) {
            // System.out.println(temp);
            if (count == 4) {
                ans.add(new String(temp.substring(0, temp.length() - 1)));
            }

            return;
        }
        
        if (count > 4) return;

        String before = temp;
        String num = "";
        for (int i = idx; i < Math.min(idx + 3, s.length()); i++) {
            num += s.charAt(i);
            // System.out.println(num);
            // System.out.println(containsLeadingZeroes(num));
            int val = Integer.parseInt(num);
            if (val >= 0 && val <= 255 && !containsLeadingZeroes(num)) {
                temp += num + ".";
                f(i + 1, s, temp, count + 1);
                temp = before;
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        f(0, s, "", 0);

        return ans;
    }
}