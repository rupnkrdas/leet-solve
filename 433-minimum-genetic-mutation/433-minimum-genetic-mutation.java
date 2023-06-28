class Pair{
    String first;
    int second;

    public Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] choices = {'A', 'C', 'G', 'T'};
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }

        q.offer(new Pair(start, 0));
        set.remove(start);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String s = p.first;
            int count = p.second;
            if (s.equals(end)) return count;

            for (int i = 0; i < s.length(); i++) {
                for (char c : choices) {
                    char[] arr = s.toCharArray();
                    arr[i] = c;
                    String s_ = new String(arr);
                    if (set.contains(s_)) {
                        set.remove(s_);
                        q.offer(new Pair(s_, count + 1));
                    }
                }
            }
        }

        return -1;
    }
}