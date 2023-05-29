class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int number = digits[i];
            if (i == n - 1) {
                number += 1;
                if (number == 10) {
                    carry = 1;
                    list.add(0);
                } else {
                    list.add(number);
                }
                continue;
            }
            number += carry;
            carry = 0;
            if (number == 10) {
                carry = 1;
                list.add(0);
            } else {
                list.add(number);
            }
        }
        
        if (carry == 1) list.add(1);
        
        int[] ans = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(list.size() - 1 - i);
        }
        
        return ans;
            
    }
}