class Solution {
    private int countOperationsStartingWith(int num, char[] arr) {
        int count = 0;
        int search = num;

        for (char c : arr) {
            if ((c - '0') != search) count++;
            search = 1 - search;
        }
        
        return count;
    }
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        
        // return min{startingWith1, startingWith0};
        return Math.min(countOperationsStartingWith(0, arr), countOperationsStartingWith(1, arr));   
    }
}