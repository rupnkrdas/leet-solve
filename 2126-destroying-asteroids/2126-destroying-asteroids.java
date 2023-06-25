class Solution {
    public boolean asteroidsDestroyed(int mass, int[] a) {
        List<Integer> asteroids = new ArrayList<>();
        for (int num : a) asteroids.add(num);
        Collections.sort(asteroids);

        long total = mass;
        for (int ast : asteroids) {
            if (total >= ast) {
                total += (long)ast;
            } else {
                return false;
            }
        }

        return true;
    }
}