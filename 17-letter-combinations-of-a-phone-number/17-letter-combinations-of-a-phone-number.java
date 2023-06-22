class Solution {
    Map<Integer, List<Character>> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        map.put(2, new ArrayList<>(list));
        list.clear();
        list.add('d');
        list.add('e');
        list.add('f');
        map.put(3, new ArrayList<>(list));
        list.clear();
        list.add('g');
        list.add('h');
        list.add('i');
        map.put(4, new ArrayList<>(list));
        list.clear();
        list.add('j');
        list.add('k');
        list.add('l');
        map.put(5, new ArrayList<>(list));
        list.clear();
        list.add('m');
        list.add('n');
        list.add('o');
        map.put(6, new ArrayList<>(list));
        list.clear();
        list.add('p');
        list.add('q');
        list.add('r');
        list.add('s');
        map.put(7, new ArrayList<>(list));
        list.clear();
        list.add('t');
        list.add('u');
        list.add('v');
        map.put(8, new ArrayList<>(list));
        list.clear();
        list.add('w');
        list.add('x');
        list.add('y');
        list.add('z');
        map.put(9, new ArrayList<>(list));
        list.clear();

        List<String> ans = new ArrayList<>();
        f(0, "", digits, ans);
        return ans;
    }

    public void f(int idx, String s, String digits, List<String> ans) {
        if (idx == digits.length()) {
            if (!s.isEmpty()) {
                ans.add(new String(s));
            }
            return;
        }

        for (char c : map.get(digits.charAt(idx) - '0')) {
            s += c;
            f(idx + 1, s, digits, ans);
            s = s.substring(0, s.length() - 1);
        }
    }
}