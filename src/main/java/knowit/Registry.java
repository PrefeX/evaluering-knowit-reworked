package knowit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import knowit.entity.Ingredient;
import knowit.entity.Recipe;
import knowit.enums.ProductClassification;


/**
 * A register responsible for maintaining the stored ingredients and recipes in
 * the system
 *
 * @author Christian
 */
public class Registry {

    private final List<Ingredient> ingredients;
    private final List<Recipe> recipes;
    private final Map<Ingredient, Integer> inventory;


    public Registry() {
        this.ingredients = new ArrayList<>();
        this.recipes = new ArrayList<>();
        this.inventory = new HashMap<>();
    }


    /**
     * Register a new ingredient to the system. This also marks the inventory of
     * the item as empty.
     *
     * @param ingredient The new ingredient we want to save
     */
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        inventory.put(ingredient, 0);
    }


    /**
     * Register a new ingredient to the system.This also set the current
     * inventory amount for the new ingredient.
     *
     * @param ingredient The new ingredient we want to save
     * @param amount The current amount we have of the ingredient
     */
    public void addIngredient(Ingredient ingredient, int amount) {
        ingredients.add(ingredient);
        inventory.put(ingredient, amount);
    }


    /**
     * Retrieve a specific ingredient by using it's ID
     *
     * @param id The ingredient's ID
     * @return The located ingredient
     */
    public Ingredient findIngredient(Long id) {
        return ingredients.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .get();
    }


    /**
     * Retrieve a specific ingredient by using it's name
     *
     * @param name The ingredient's name
     * @return The located ingredient
     */
    public Ingredient findIngredient(String name) {
        return ingredients.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .get();
    }


    /**
     * Searches through the registry and returns a list containing all
     * ingredients that matches the input
     *
     * @param name What we are searching for
     * @return A list containing the matching results
     */
    public List<Ingredient> searchForIngredient(String name) {
        return ingredients.stream()
                .filter(e -> e.getName().contains(name))
                .sorted()
                .collect(Collectors.toList());
    }


    /**
     * Adds a new recipe to the system
     *
     * @param recipe The recipe we want to store
     */
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }


    /**
     * Retrieve a specific recipe by using it's ID
     *
     * @param id The recipes ID
     * @return The located recipe
     */
    public Recipe findRecipe(Long id) {
        return recipes.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .get();
    }


    /**
     * Retrieve a specific recipe by using it's name
     *
     * @param name The recipes name
     * @return The located recipe
     */
    public Recipe findRecipe(String name) {
        return recipes.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .get();
    }


    /**
     * Searches through the registry and returns a list containing all recipes
     * that contains the provided classification
     *
     * @param classification The recipes product classification
     * @return A list containing the matching results
     */
    public List<Recipe> searchForRecipe(ProductClassification classification) {
        return recipes.stream()
                .filter(e -> e.getClassification().equals(classification))
                .collect(Collectors.toList());
    }


    /**
     * Searches through the registry and returns a list containing all recipes
     * that contains the provided string
     *
     * @param name What we are searching for
     * @return A list containing the matching results
     */
    public List<Recipe> searchForRecipe(String name) {
        // Todo: Add sorting
        return recipes.stream()
                .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }


    /**
     * Searches through the registry and returns a list containing all recipes
     * that is registered on a determined date
     *
     * @param dateAdded The date the recipe was added
     * @return A list containing the matching results
     */
    public List<Recipe> searchForRecipe(LocalDate dateAdded) {
        // Todo: Add sorting
        return recipes.stream()
                .filter(e -> dateAdded.equals(e.getDateAdded()))
                .collect(Collectors.toList());
    }


    /**
     * Searches through the registry and returns a list containing all recipes
     * that is registered either on or in between between two provided dates
     *
     * @param fromDate The earliest date we want to search for
     * @param toDate The latest date we want to search for
     * @return A list containing the matching results
     */
    public List<Recipe> searchForRecipe(LocalDate fromDate, LocalDate toDate) {
        // Todo: Add sorting
        return recipes.stream()
                .filter(e -> e.getDateAdded().equals(fromDate) || e.getDateAdded().equals(toDate) || (e.getDateAdded().isAfter(fromDate) && e.getDateAdded().isBefore(toDate)))
                .collect(Collectors.toList());
    }


    /**
     * Add additional stock of an ingredient to our current inventory
     *
     * @param ingredient The ingredient we are adding stock for
     * @param amount How much we are adding
     */
    public void addToInventory(Ingredient ingredient, int amount) {
        int oldValue = inventory.get(ingredient);
        inventory.put(ingredient, (oldValue + amount));
    }


    /**
     * Removes stock of an ingredient from our current inventory
     *
     * @param ingredient The ingredient where we are removing or using stock
     * @param amount How much we are removing or using
     */
    public void removeFromInventory(Ingredient ingredient, int amount) {
        int oldValue = inventory.get(ingredient);
        inventory.put(ingredient, (oldValue - amount));
    }


    /**
     * Set the stock to a new, predetermined amount
     *
     * @param ingredient The ingredient we are changing the stock for
     * @param amount The new amount
     */
    public void setInventoryAmount(Ingredient ingredient, int amount) {
        inventory.put(ingredient, amount);
    }


    /**
     * Simple getter for the ingredient registry
     *
     * @return The ingredient registry
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }


    /**
     * Simple getter for the recipes registry
     *
     * @return The recipe registry
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }


    /**
     * Simple getter for the inventory registry
     *
     * @return The inventory registry
     */
    public Map<Ingredient, Integer> getInventory() {
        return inventory;
    }

}
