class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) list.add(Integer.toString(num));
//         Collections.sort(list, new Comparator<String>() {
//             public int compare(String num1, String num2) {
//                 String s1 = num1 + num2;
//                 String s2 = num2 + num1;

//                 return s1.compareTo(s2);
//             }
//         });
        Collections.sort(list, (num1, num2) -> {
           return (num1 + num2).compareTo(num2 + num1); 
        });

        System.out.println(list);
        
        String res = "";
        for (String num : list) res = num + res;

        return (res.charAt(0) != '0') ? res : "0";
    }
}