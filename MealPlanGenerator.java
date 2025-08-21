interface MealPlan {
    String getType();
    int getCalories();
    boolean isValid();
}

class VegetarianMeal implements MealPlan {
    public String getType() { return "Vegetarian"; }
    public int getCalories() { return 500; }
    public boolean isValid() { return true; }
}

class VeganMeal implements MealPlan {
    public String getType() { return "Vegan"; }
    public int getCalories() { return 450; }
    public boolean isValid() { return true; }
}

class KetoMeal implements MealPlan {
    public String getType() { return "Keto"; }
    public int getCalories() { return 600; }
    public boolean isValid() { return true; }
}

class HighProteinMeal implements MealPlan {
    public String getType() { return "High-Protein"; }
    public int getCalories() { return 550; }
    public boolean isValid() { return true; }
}

class Meal<T extends MealPlan> {
    private String name;
    private T mealPlan;
    
    public Meal(String name, T mealPlan) {
        this.name = name;
        this.mealPlan = mealPlan;
    }
    
    public String getName() { return name; }
    public T getMealPlan() { return mealPlan; }
    
    public String toString() {
        return name + " (" + mealPlan.getType() + ") - " + mealPlan.getCalories() + " calories";
    }
}

class MealGenerator {
    
    public static <T extends MealPlan> Meal<T> createMeal(String name, T mealPlan) {
        if (mealPlan.isValid()) {
            return new Meal<>(name, mealPlan);
        }
        throw new IllegalArgumentException("Invalid meal plan");
    }
    
    public static <T extends MealPlan> java.util.List<Meal<T>> generateDayPlan(T mealType, String[] mealNames) {
        java.util.List<Meal<T>> dayPlan = new java.util.ArrayList<>();
        for (String mealName : mealNames) {
            dayPlan.add(createMeal(mealName, mealType));
        }
        return dayPlan;
    }
    
    public static void displayMealPlan(java.util.List<? extends Meal<? extends MealPlan>> meals) {
        System.out.println("Daily Meal Plan:");
        int totalCalories = 0;
        for (Meal<? extends MealPlan> meal : meals) {
            System.out.println("  " + meal);
            totalCalories += meal.getMealPlan().getCalories();
        }
        System.out.println("Total Calories: " + totalCalories + "\n");
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        System.out.println("=== Personalized Meal Plan Generator ===\n");
        
        String[] breakfastLunch = {"Breakfast", "Lunch"};
        String[] allMeals = {"Breakfast", "Lunch", "Dinner"};
        
        java.util.List<Meal<VegetarianMeal>> vegPlan = 
            MealGenerator.generateDayPlan(new VegetarianMeal(), breakfastLunch);
        
        java.util.List<Meal<VeganMeal>> veganPlan = 
            MealGenerator.generateDayPlan(new VeganMeal(), allMeals);
        
        java.util.List<Meal<KetoMeal>> ketoPlan = 
            MealGenerator.generateDayPlan(new KetoMeal(), breakfastLunch);
        
        java.util.List<Meal<HighProteinMeal>> proteinPlan = 
            MealGenerator.generateDayPlan(new HighProteinMeal(), allMeals);
        
        System.out.println("VEGETARIAN PLAN:");
        MealGenerator.displayMealPlan(vegPlan);
        
        System.out.println("VEGAN PLAN:");
        MealGenerator.displayMealPlan(veganPlan);
        
        System.out.println("KETO PLAN:");
        MealGenerator.displayMealPlan(ketoPlan);
        
        System.out.println("HIGH-PROTEIN PLAN:");
        MealGenerator.displayMealPlan(proteinPlan);
        
        Meal<VegetarianMeal> customMeal = MealGenerator.createMeal("Custom Salad", new VegetarianMeal());
        System.out.println("Custom Meal: " + customMeal);
    }
}