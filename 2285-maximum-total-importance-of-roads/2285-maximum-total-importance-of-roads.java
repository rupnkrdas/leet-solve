class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] indegree = new int[n];
        for (int[] e : roads) {
            int u = e[0];
            int v = e[1];

            indegree[u]++;
            indegree[v]++;
        }

        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{i, indegree[i]});
        }

        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2) {
                return (p2[1] != p1[1]) ? p2[1] - p1[1] : p2[0] - p1[0];
            }
        });

        // for (int[] l : list) {
        //     System.out.println(Arrays.toString(l));
        // }

        int imp = n;
        for (int[] l : list) {
            l[1] = imp--;
        }

        for (int[] l : list) {
            map.put(l[0], l[1]);
        }

        long sum = 0;
        for (int[] r : roads) {
            int u = r[0];
            int v = r[1];

            sum += (long)map.get(u) + (long)map.get(v);
        }


        return sum;
    }
}