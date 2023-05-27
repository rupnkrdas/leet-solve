class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int k = p.length(); 
        Map<Character, Integer> map = new HashMap<>(); // frequency map
        for (int i = 0; i < k; i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int count = map.size();
        
        int i = 0;
        int j = 0;
        while(j < n) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }
            
            if (j - i + 1 < k) {
                j++;
            }
            
            else if (j - i + 1 == k) {
                if (count == 0) {
                    ans.add(i);
                }
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                }
                if (map.getOrDefault(ch, 0) == 1) count++;
                i++;
                j++;
            }
        }
        
        return ans;
    }
}