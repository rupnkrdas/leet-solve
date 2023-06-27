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
}
class Solution {
    public String frequencySort(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = arr[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            char c = e.getKey();
            int freq = e.getValue();
            pq.offer(new Pair(c, freq));
        }
        String res = "";
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int freq = pair.second;
            char c = pair.first;

            while (freq-- > 0) {
                res += c;
            }
        }

        return res;
    }
}