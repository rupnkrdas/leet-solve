import java.util.*;
class Tuple {
    int first;
    int second;
    int third;

    public Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    @Override
    public String toString() {
        return "[" + first + ", " + second + ", " + third + "]";
    }
}

class LFUCache {
    int cap;
    int size;

    Map<Integer, Tuple> map = new HashMap<>(); // key -> Tuple{key, val, counter}
    Map<Integer, LinkedList<Tuple>> freq = new TreeMap<>(); // counter -> LinkedList<Tuple>

    public LFUCache(int capacity) {
        cap = capacity;
        size = 0;
    }
    
    private void updateCounter(int key) {
        Tuple t = map.get(key);
        int val = t.second;
        int counter = t.third;
        
        freq.get(counter).remove(t);
        if (freq.get(counter).isEmpty()) freq.remove(counter);
        
        counter++;
        t.third = counter;
        if (freq.containsKey(counter)) {
            freq.get(counter).addFirst(t);
        } else {
            LinkedList<Tuple> list = new LinkedList<>();
            list.addLast(t);
            freq.put(counter, list);
        }
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            Tuple t = map.get(key);
            updateCounter(key);
            
            return t.second;
        }
    }
    
    public void put(int key, int value) {
        if (cap == 0) return;
        
        if (map.containsKey(key)) {
            Tuple t = map.get(key);
            t.second = value;
            
            updateCounter(key);
        } else {
            if (size < cap) {
                Tuple newTuple = new Tuple(key, value, 1);
                map.put(key, newTuple);
                
                if (freq.containsKey(1)) {
                    freq.get(1).addFirst(newTuple);
                } else {
                    LinkedList<Tuple> list = new LinkedList<>();
                    list.addLast(newTuple);
                    freq.put(1, list);
                }
                
                size++;
            } else {
                Map.Entry<Integer, LinkedList<Tuple>> firstEntry = freq.entrySet().iterator().next();
                LinkedList<Tuple> firstList = firstEntry.getValue();
                Tuple t = firstList.removeLast();
                int last_key = t.first;
                int last_counter = t.third;
                if (firstList.isEmpty()) freq.remove(last_counter);
                map.remove(last_key);
                
                Tuple newTuple = new Tuple(key, value, 1);
                map.put(key, newTuple);
                if (freq.containsKey(1)) {
                    freq.get(1).addFirst(newTuple);
                } else {
                    LinkedList<Tuple> list = new LinkedList<>();
                    list.addLast(newTuple);
                    freq.put(1, list);
                }
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */