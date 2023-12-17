class Food implements Comparable<Food>{
    String food;
    String cuisine;
    int rating;

    public Food(String food, String cuisine, int rating) {
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    public int compareTo(Food other) {
        return (this.rating != other.rating) ? other.rating - this.rating : this.food.compareTo(other.food);
    }
}
class FoodRatings {
    Map<String, Food> foodMap = new HashMap<>();
    Map<String, PriorityQueue<Food>> cuisineToFood = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;

        for (int i = 0; i < n; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            if (!cuisineToFood.containsKey(cuisine)) cuisineToFood.put(cuisine, new PriorityQueue<>());
            Food newFood = new Food(food, cuisine, rating);
            cuisineToFood.get(cuisine).add(newFood);
            foodMap.put(food, newFood);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food oldFood = foodMap.get(food);
        cuisineToFood.get(oldFood.cuisine).remove(oldFood);
        oldFood.rating = newRating;
        cuisineToFood.get(oldFood.cuisine).add(oldFood);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFood.get(cuisine).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */