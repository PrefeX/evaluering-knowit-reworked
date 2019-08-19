package knowit;

import java.time.LocalDate;
import java.util.List;
import knowit.entity.Ingredient;
import knowit.entity.Recipe;
import knowit.enums.ProductClassification;


/**
 * The application class, containing the top-level business logic
 *
 * @author Christian
 */
public class Application {

    private final Registry registry;


    public Application() {
        this.registry = new Registry();
        addDummyData();
        find();
    }


    /**
     * Populate with some dummy-data used for testing
     */
    private void addDummyData() {
        LocalDate date = LocalDate.now();

        // Create ingredients
        Ingredient ingredient1 = new Ingredient("Sukker");
        Ingredient ingredient2 = new Ingredient("Egg");
        Ingredient ingredient3 = new Ingredient("Mel");

        // Create recipies
        Recipe recipe1 = new Recipe.Builder("Skolebolle", ProductClassification.Gjærbakst).addIngredient(ingredient1, 4).addIngredient(ingredient2, 6).build();
        recipe1.setDateAdded(date.minusMonths(1));

        Recipe recipe2 = new Recipe.Builder("Bolle", ProductClassification.Gjærbakst).addIngredient(ingredient1, 3).build();
        recipe1.setDateAdded(date.minusWeeks(1));

        Recipe recipe3 = new Recipe.Builder("Berlinerbolle", ProductClassification.Kremkaker).addIngredient(ingredient1, 6).addIngredient(ingredient3, 3).build();
        recipe1.setDateAdded(date.minusDays(3));

        Recipe recipe4 = new Recipe.Builder("Sjokoladekake", ProductClassification.Annet).addIngredient(ingredient2, 3).addIngredient(ingredient2, 8).build();
        recipe4.setDateAdded(date);

        // Add ingredients
        registry.addIngredient(ingredient1, 50);
        registry.addIngredient(ingredient2);
        registry.addIngredient(ingredient3, 25);

        // Add recipies
        registry.addRecipe(recipe1);
        registry.addRecipe(recipe2);
        registry.addRecipe(recipe3);
        registry.addRecipe(recipe4);
    }


    private void find() {
        LocalDate date = LocalDate.now();

        List<Recipe> search1 = registry.searchForRecipe("bolle");
        List<Recipe> search2 = registry.searchForRecipe(date);
        List<Recipe> search3 = registry.searchForRecipe(date.minusDays(1), date);

        System.out.println("\n\nSearch by name (bolle)");
        search1.stream().forEach(e -> System.out.println(e.toString()));

        System.out.println("\n\nSearch by name date");
        search2.stream().forEach(e -> System.out.println(e.toString()));

        System.out.println("\n\nSearch by name dates");
        search3.stream().forEach(e -> System.out.println(e.toString()));
    }

}
