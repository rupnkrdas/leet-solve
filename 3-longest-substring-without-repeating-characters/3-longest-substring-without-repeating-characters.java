class Solution {
    public int lengthOfLongestSubstring(String s) {
        return f(s);
    }

    public int f(String s) {
        int n = s.length();
        if (n == 0) return 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(); // (character -> count)
        int i = 0;
        int j = 0;
        int maxi = 1;
        while (j < n) {
            char c = arr[j];
            
            // calculation
            map.put(c, map.getOrDefault(c, 0) + 1);


            // condition met
            if (map.size() == j - i + 1) {
                maxi = Math.max(maxi, j - i + 1);
            }

            // condition exceeds
            if (map.size() < j - i + 1) {
                if (map.size() < j - i + 1) {
                    char a = arr[i];
                    map.put(a, map.get(a) - 1);
                    if (map.get(a) == 0) {
                        map.remove(a);
                    }
                    i++;
                }
            }
            j++;
        }

        return maxi;
    }
}