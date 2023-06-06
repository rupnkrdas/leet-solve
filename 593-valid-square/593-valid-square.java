class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Integer> list = new ArrayList<>();
        list.add(getDistance(p1, p2));
        list.add(getDistance(p1, p3));
        list.add(getDistance(p1, p4));
        list.add(getDistance(p2, p3));
        list.add(getDistance(p2, p4));
        list.add(getDistance(p3, p4));

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int dist : list) {
            if (dist == 0) return false;
            map.put(dist, map.getOrDefault(dist, 0) + 1);
        }
        if (map.size() != 2) return false;
        for (int val : map.values()) {
            return val == 2 || val == 4;
        }
        return false;
    }

    public int getDistance(int[] x, int[] y) {
        return (x[0] - y[0])*(x[0] - y[0]) + (x[1] - y[1])*(x[1] - y[1]);
    }
}