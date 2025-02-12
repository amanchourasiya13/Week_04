package Day01_JavaGenerics.ProblemStatement.PersonalizedMealPlanGenerator;

public class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public String generateMealPlan() {
        return "Meal Plan: " + mealPlan.getMealCategory();
    }

    public static <T extends MealPlan> String validateAndGenerateMealPlan(T mealPlan) {
        // Validating the meal plan
        if (mealPlan == null) {
            return "Invalid meal plan: Meal plan cannot be null!";
        }
        return "Generated " + mealPlan.getMealCategory() + " successfully!";
    }
}
