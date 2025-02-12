package Day01_JavaGenerics.ProblemStatement.PersonalizedMealPlanGenerator;
//package Day01_JavaGenerics.ProblemStatement.PersonalizedMealPlanGenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealPlanGeneratorTest {

    @Test
    void testVegetarianMealGeneration() {
        Meal<VegetarianMeal> vegetarianMeal = new Meal<>(new VegetarianMeal());
        String result = vegetarianMeal.generateMealPlan();
        assertEquals("Meal Plan: Vegetarian Meal", result);
    }

    @Test
    void testVeganMealGeneration() {
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        String result = veganMeal.generateMealPlan();
        assertEquals("Meal Plan: Vegan Meal", result);
    }

    @Test
    void testKetoMealGeneration() {
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        String result = ketoMeal.generateMealPlan();
        assertEquals("Meal Plan: Keto Meal", result);
    }

    @Test
    void testHighProteinMealGeneration() {
        Meal<HighProteinMeal> highProteinMeal = new Meal<>(new HighProteinMeal());
        String result = highProteinMeal.generateMealPlan();
        assertEquals("Meal Plan: High-Protein Meal", result);
    }

    @Test
    void testMealPlanValidation() {
        // Validating different meal plans
        String resultVegetarian = Meal.validateAndGenerateMealPlan(new VegetarianMeal());
        assertEquals("Generated Vegetarian Meal successfully!", resultVegetarian);

        String resultVegan = Meal.validateAndGenerateMealPlan(new VeganMeal());
        assertEquals("Generated Vegan Meal successfully!", resultVegan);

        String resultKeto = Meal.validateAndGenerateMealPlan(new KetoMeal());
        assertEquals("Generated Keto Meal successfully!", resultKeto);

        String resultHighProtein = Meal.validateAndGenerateMealPlan(new HighProteinMeal());
        assertEquals("Generated High-Protein Meal successfully!", resultHighProtein);
    }

    @Test
    void testMealPlanValidationWithNull() {
        // Null validation test
        String resultNull = Meal.validateAndGenerateMealPlan(null);
        assertEquals("Invalid meal plan: Meal plan cannot be null!", resultNull);
    }
}
