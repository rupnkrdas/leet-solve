class Solution {
    public double angleClock(int hour, int minutes) {
        double hours = hour + (double)minutes/60;
        double ans = Math.abs(hours*30 - minutes*6);
        if (ans > 180) return 360 - ans;
        else return ans;
    }
}