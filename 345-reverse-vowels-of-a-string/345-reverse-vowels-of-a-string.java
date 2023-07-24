class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');

        int n = s.length();
        char[] res = new char[n];
        LinkedList<Character> list = new LinkedList<>();
        Set<Integer> idx = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            
            if (set.contains(c)) { // vowel
                idx.add(i);
                list.addLast(c);
            } else { // consonent
                res[i] = c;
            }
        }

        Collections.reverse(list);
        for (int j = 0; j < n; j++) {
            if(idx.contains(j)) {
                res[j] = list.removeFirst();
            }
        }

        return new String(res);
    }
}