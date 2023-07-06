class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deck) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        // System.out.println(map);
        List<Integer> list = new ArrayList<>();
        for (int val : map.values()) {
            list.add(val);
        }
        
        int gcd = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            gcd = get_gcd(gcd, list.get(i));
        }

        return gcd != 1;
    }

    public int get_gcd(int a, int b) {
        if (a % b == 0) return b;
        else return get_gcd(b, a % b);
    }
}