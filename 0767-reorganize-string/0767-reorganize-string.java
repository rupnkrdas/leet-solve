class Pair implements Comparable<Pair> {
    char first;
    int second;

    public Pair(char first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair other) {
        return other.second - this.second;
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + "]";
    }
}
class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        String res = "";
        int[] freq = new int[26];
        for (char c : arr) {
            freq[c-'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 'a');
            int f = freq[c-'a'];
            if (f > 0) {
                pq.offer(new Pair(c, f));
            }
        }

        while (!pq.isEmpty()) {
            
            Pair p = pq.poll();
            char ch = p.first;
            int f = p.second;

            if (res.isEmpty() || res.charAt(res.length() - 1) != ch) {
                res += ch;
                f--;
                if (f > 0) {
                    pq.offer(new Pair(ch, f));
                }
            } else if (!res.isEmpty() && res.charAt(res.length() - 1) == ch) {
                if (pq.isEmpty()) return "";
                Pair p_ = pq.poll();
                char ch_ = p_.first;
                int f_ = p_.second;

                res += ch_;
                f_--;
                if (f_ > 0) {
                    pq.offer(new Pair(ch_, f_));
                }
                pq.offer(new Pair(ch, f));
            }

            // System.out.println("res : " + res + " " + "pq : " + pq);
        }

        if (res.length() == n) return res;
        else return "";
    }
}