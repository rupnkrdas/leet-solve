class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        int i = k, j = k;

        int n = nums.size();
        int maxi = INT_MIN;
        int mini = nums[k];
        while (i >= 0 && j < n) {
            mini = min({mini, nums[i], nums[j]});
            maxi = max(maxi, mini * (j - i + 1));
            
            // go towards left or right
            int left = (i - 1 >= 0) ? nums[i - 1] : INT_MIN;
            int right = (j + 1 < n) ? nums[j + 1] : INT_MIN;

            if (left > right) i--;
            else j++;
        }

        return maxi;
    }
};