class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        int f = 0;

        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if (set.contains(arr[i])) {
                f++;
            }
        }
        for (int i = n/2; i < n; i++) {
            if (set.contains(arr[i])) {
                f--;
            }
        }

        return f == 0;
    }
}