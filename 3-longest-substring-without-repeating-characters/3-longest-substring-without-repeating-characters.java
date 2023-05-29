class Solution {
    public int lengthOfLongestSubstring(String s) {
        return f(s, s.length());
    }
    
    public int f(String s, int n) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int i = 0;
        int j = 0;
        int maxi = 0;
        int count = 0;
        while (j < n) {
            char c = arr[j];
            map.put(c, map.getOrDefault(c, 0) + 1);
            count++;
            
            if (map.size() == count) {
                maxi = Math.max(j - i + 1, maxi);
                j++;
            }
            
            else if (map.size() < count) {
                while (map.size() < count) {
                    char ch = arr[i];
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) map.remove(ch);
                    count--;
                    i++;
                }
                j++;
            }
        }
        
        return maxi;
    }
} 