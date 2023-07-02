class Solution {
    int maxi = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        f(0, requests, indegree, 0);
        return maxi;
    }

    public void f(int index, int[][] request, int[] indegree, int count) {
        if (index == request.length) {
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] != 0) return;
            }

            maxi = Math.max(maxi, count);
            return;
        }


        //take
        indegree[request[index][0]]--;
        indegree[request[index][1]]++;
        f(index + 1, request, indegree, count + 1);

        //nottake
        indegree[request[index][0]]++;
        indegree[request[index][1]]--;
        f(index + 1, request, indegree, count);
    }
}