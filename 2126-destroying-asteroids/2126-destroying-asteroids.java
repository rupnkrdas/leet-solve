class Solution {
    public boolean asteroidsDestroyed(int mass, int[] a) {
        Arrays.sort(a);

        long total = mass;
        for (int ast : a) {
            if (total >= ast) {
                total += (long)ast;
            } else {
                return false;
            }
        }

        return true;
    }
}