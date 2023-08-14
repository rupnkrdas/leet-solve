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
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        if (a != 0) {
            pq.offer(new Pair('a', a));
        }
        if (b != 0) {
            pq.offer(new Pair('b', b));
        }
        if (c != 0) {
            pq.offer(new Pair('c', c));
        }

        // System.out.println(pq);

        String s = "";

        while (!pq.isEmpty()) {
            // System.out.println("s : " + s + " " + "pq : " + pq);
            int n = s.length();
            Pair pair = pq.poll();
            char ch = pair.first;
            int f = pair.second;
            
            if (n - 2 >= 0 && s.charAt(n - 2) == s.charAt(n - 1)) {
                char same = s.charAt(n - 1);
                if (ch == same) {
                    if (pq.isEmpty()) return s;
                    else {
                        Pair pair_ = pq.poll();
                        char ch_ = pair_.first;
                        int f_ = pair_.second;

                        s += ch_;
                        f_--;

                        if (f_ > 0) {
                            pq.offer(new Pair(ch_, f_));
                        }
                    }
                    pq.offer(pair);
                } else {
                    s += ch;
                    f--;

                    if (f > 0) {
                        pq.offer(new Pair(ch, f));
                    }
                }
            } else {
                s += ch;
                f--;

                if (f > 0) {
                    pq.offer(new Pair(ch, f));
                }
            }
        }

        return s;
    }
}