class Solution {
    int maxi = 0;

    private void f(int idx, List<Integer> brr, int temp) {
        maxi = Math.max(maxi, Integer.bitCount(temp));

        for (int i = idx; i < brr.size(); i++) {
            if ((temp & brr.get(i)) == 0) f(i + 1, brr, temp | brr.get(i));
        }
    }
    public int maxLength(List<String> arr) {
        List<Integer> brr = new ArrayList<>();
        for (String s: arr) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }

            if (set.size() == s.length()) {
                int mask = 0;
                for (int i = 0; i < s.length(); i++) {
                    mask |= 1 << (s.charAt(i) - 'a');
                }

                brr.add(mask);
            }
        }

        f(0, brr, 0);

        return maxi;
    }
}