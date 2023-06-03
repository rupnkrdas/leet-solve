class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        // n^2logn
        for (int i = 0; i < n; i++) {
            String str = strs[i];
            String sorted = sort(str);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> l : map.values()) {
            ans.add(l);
        }

        return ans;
    }

    // nlogn
    public String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        return new String(arr);
    }
}