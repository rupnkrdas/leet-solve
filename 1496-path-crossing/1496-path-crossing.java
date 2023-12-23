class Solution {
    public boolean isPathCrossing(String path) {
        char[] arr = path.toCharArray();
        Set<String> set = new HashSet<>();

        int[] pos = {0, 0};
        set.add("0,0");
        for (char c : arr) {
            if (c == 'N') {
                pos[0]++;
            } else if (c == 'E') {
                pos[1]++;
            } else if (c == 'W') {
                pos[1]--;
            } else {
                pos[0]--;
            }

            String newPos = Integer.toString(pos[0]) + "," + Integer.toString(pos[1]); 

            if (set.contains(newPos)) return true;
            set.add(newPos);
        }

        return false;
    }
}