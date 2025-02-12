package Day01_JavaGenerics.ProblemStatement.PersonalizedMealPlanGenerator;

public class MealPlanGenerator {
    public static void main(String[] args) {
        // Creating instances of different meal plans
        Meal<VegetarianMeal> vegetarianMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> highProteinMeal = new Meal<>(new HighProteinMeal());

        // Generating meal plans
        System.out.println(vegetarianMeal.generateMealPlan());
        System.out.println(veganMeal.generateMealPlan());
        System.out.println(ketoMeal.generateMealPlan());
        System.out.println(highProteinMeal.generateMealPlan());

        // Validating and generating meal plans
        System.out.println(Meal.validateAndGenerateMealPlan(new VegetarianMeal()));
        System.out.println(Meal.validateAndGenerateMealPlan(new VeganMeal()));
        System.out.println(Meal.validateAndGenerateMealPlan(new KetoMeal()));
        System.out.println(Meal.validateAndGenerateMealPlan(new HighProteinMeal()));
    }
}

