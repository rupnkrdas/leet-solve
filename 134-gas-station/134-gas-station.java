class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_gas = 0;
        int total_cost = 0;
        for (int i = 0; i < n; i++) {
            total_gas += gas[i];
            total_cost += cost[i];
        }

        if (total_cost > total_gas) return -1;

        int total = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                index = i + 1;
            }
        }

        return index;
    }
}