class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rand = new Random();
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            int index = list.size() - 1;
            map.put(val, index);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        
        else {
            int index = map.remove(val);
            int last = list.remove(list.size() - 1);
            if (last != val) {
                map.put(last, index);
                list.set(index, last);
            }
            return true;
        }
    }
    
    public int getRandom() {
       return list.get((rand.nextInt(list.size())));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */