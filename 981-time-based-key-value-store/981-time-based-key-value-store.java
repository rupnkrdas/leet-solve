class Pair {
    int time;
    String value;

    public Pair(int time, String value) {
        this.time = time;
        this.value = value;
    }
}

class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
            map.get(key).add(new Pair(timestamp, value));
        } else {
            map.get(key).add(new Pair(timestamp, value));
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if(list == null) return "";
        if(list.isEmpty()) return "";
        else {
            int start = 0;
            int end = list.size() - 1;
            String res = "";

            while (start <= end) {
                int mid = start + (end - start)/2;

                if (list.get(mid).time == timestamp) return list.get(mid).value;
                else if (list.get(mid).time < timestamp) {
                    res = list.get(mid).value;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return res;
        }
    }

    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */