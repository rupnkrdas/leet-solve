class Solution {
    public int totalFruit(int[] fruits) {
        return f(fruits, fruits.length);
    }
    
    public int f(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxi = 1;
        
        while (j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            
            if (map.size() < 2) {
                maxi = Math.max(j - i + 1, maxi);
                j++;
            }
            
            else if (map.size() == 2) {
                maxi = Math.max(j - i + 1, maxi);
                j++;
            }
            
            else if (map.size() > 2) {
                while (map.size() > 2) {
                    map.put(arr[i], map.get(arr[i]) - 1);
                    if (map.get(arr[i]) == 0) map.remove(arr[i]);
                    i++;
                }
                j++;
            }
        }
        
        System.out.println(map);
        
        return maxi;
    }
}