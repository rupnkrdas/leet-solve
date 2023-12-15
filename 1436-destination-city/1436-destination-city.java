class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (List<String> p : paths) {
            String city = p.get(0);
            set.add(city);
        }

        for (List<String> p : paths) {
            String city = p.get(1);
            if (!set.contains(city)) return city;
        }

        return "";
    }
}