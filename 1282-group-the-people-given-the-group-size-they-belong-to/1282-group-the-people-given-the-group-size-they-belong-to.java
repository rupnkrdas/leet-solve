class Solution {
    public List<List<Integer>> groupThePeople(int[] grp) {
        Map<Integer, List<List<Integer>>> map = new TreeMap<>();
        for (int i = 0; i < grp.length; i++) {
            // System.out.println(map);
            int group = grp[i];
            if (!map.containsKey(group)) {
                map.put(group, new ArrayList<>());
                // System.out.println(map);
            } 
            if (map.containsKey(group)) {
                List<List<Integer>> outerList = map.get(group);
                if (outerList.isEmpty() || outerList.get(outerList.size() - 1).size() == group) {
                    outerList.add(new ArrayList<>());
                }
            }

            List<List<Integer>> outerList = map.get(group);
            // System.out.println(outerList);
            outerList.get(outerList.size() - 1).add(i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (List<List<Integer>> l : map.values()) {
            ans.addAll(l);
        }

        return ans;
    }
}