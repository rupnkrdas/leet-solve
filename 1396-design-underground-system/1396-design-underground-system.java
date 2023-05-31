class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkInMap;
    Map<String, List<Integer>> routeMap;

    public UndergroundSystem() {
        this.checkInMap = new HashMap<>();
        this.routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> pair = checkInMap.get(id);
        checkInMap.remove(id);

        String route = pair.getKey() + "-" + stationName;
        int time = t - pair.getValue();

        List<Integer> list = routeMap.getOrDefault(route, new ArrayList<>());
        list.add(time);
        routeMap.put(route, new ArrayList<>(list));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        List<Integer> list = routeMap.get(route);
        int sum = 0;
        for (int num : list) {
            sum += num;
        }

        return (double)sum / list.size();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */