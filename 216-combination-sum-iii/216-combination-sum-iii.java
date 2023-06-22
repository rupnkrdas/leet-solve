class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, new ArrayList<>(), 1, n, k);
        
        return ans;
    }
    
    void solve(List<List<Integer>> ans, List<Integer> list, int start, int target, int k) {
         if (list.size() == k && target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (start == 10) {
            return;
        }
        
        list.add(start);
        solve(ans, list, start + 1, target - start, k);
        list.remove(list.size() - 1);
        solve(ans, list, start + 1, target, k);
    } 
}