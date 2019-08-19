package knowit.entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import knowit.enums.ProductClassification;
import knowit.util.IdGenerator;


/**
 * Represents a single recipe
 *
 * @author Christian
 */
public class Recipe {

    private Long id;
    private String name;
    private ProductClassification classification;
    private LocalDate dateAdded;

    // Ingredients and the required amounts
    private Map<Ingredient, Integer> ingredients;


    /**
     * Private constructor, forcing the users to use the builder instead.
     */
    private Recipe() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public ProductClassification getClassification() {
        return classification;
    }


    public void setClassification(ProductClassification classification) {
        this.classification = classification;
    }


    public LocalDate getDateAdded() {
        return dateAdded;
    }


    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }


    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }


    public void setIngredients(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }


    public void addIngredient(Ingredient ingredient, int amount) {
        this.ingredients.put(ingredient, amount);
    }


    public int getIngredientAmount(Ingredient ingredient) {
        return this.ingredients.get(ingredient);
    }


    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", name=" + name + ", classification=" + classification + ", dateAdded=" + dateAdded + ", ingredients=" + ingredients + '}';
    }


    /**
     * Internal class allowing us to use a builder for the entity.
     */
    public static class Builder {

        private final String name;
        private final ProductClassification classification;

        // Ingredients and the required amounts
        private final Map<Ingredient, Integer> ingredients;


        public Builder(String name, ProductClassification classification) {
            this.ingredients = new HashMap<>();
            this.name = name;
            this.classification = classification;
        }


        /**
         * Add a new ingredient to the recipe
         *
         * @param ingredient The ingredient we are adding
         * @param amount The amount we need to make it
         * @return Return itself, allowing us to chain commands.
         */
        public Builder addIngredient(Ingredient ingredient, int amount) {
            this.ingredients.put(ingredient, amount);
            return this;
        }


        /**
         * Mark the builder as done, and construct the recipe
         *
         * @return The constructed recipe
         */
        public Recipe build() {
            Recipe recipe = new Recipe();
            recipe.setId(IdGenerator.generateId());
            recipe.setDateAdded(LocalDate.now());

            recipe.setName(name);
            recipe.setClassification(classification);
            recipe.setIngredients(ingredients);

            validate();
            return recipe;
        }


        private void validate() {
            // TODO: Add validation criterias here
        }
    }
}
