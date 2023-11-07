class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        // dist: 3,2,4  speed: 5,3,2
        // time: 0,0,2

        // sort on the basis of time
        // 1, 3, 4
        // 0<1 eliminate -> charge=1 1<3 eliminate -> charge=2 2<4 eliminate


        int N = dist.length;
        double[] time = new double[N];
        for (int i = 0; i < N; i++) {
            time[i] = 1.0*dist[i]/speed[i];
        }

        Arrays.sort(time);
        double chargeTime = 0;
        int cnt = 0;

        for (int i = 0; i < time.length; i++) {
            System.out.println(cnt);  
            if (chargeTime < time[i]) {
                cnt++;
                chargeTime += 1;
            } else {
                return cnt;
            }
        }

        return cnt;
    }
}