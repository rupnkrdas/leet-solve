class Solution {
    public int minMoves(int target, int k) {
        int moves = 0;
        while (target != 1) {
            if (k == 0) {
                moves += target - 1;
                break;
            }

            if ((target % 2) == 0) {
                target /= 2;
                k--;
            } else {
                target--;
            }

            moves++;
        }

        return moves;
    }
}