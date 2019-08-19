package knowit.entity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


/**
 *
 * @author Christian
 */
public class IngredientTest {

    public IngredientTest() {
    }

    Ingredient ingredient1, ingredient2;
    String name1, name2;


    @BeforeClass
    public static void setUpClass() {
    }


    @AfterClass
    public static void tearDownClass() {
    }


    @BeforeEach
    public void setUp() {
        name1 = "Egg";
        name2 = "Sugar";
        ingredient1 = new Ingredient(name1);
        ingredient2 = new Ingredient(name2);
    }


    @AfterEach
    public void tearDown() {
        ingredient1 = null;
        ingredient2 = null;
        name1 = null;
        name2 = null;
    }


    /**
     * Test of getId method, of class Ingredient.
     */
    @Test
    public void testGetId() {
        assertAll(
                () -> assertNotNull(ingredient1.getId()),
                () -> assertNotNull(ingredient2.getId()),
                () -> assertNotEquals(ingredient1.getId(), ingredient2.getId())
        );
    }


    /**
     * Test of setId method, of class Ingredient.
     */
    @Test
    public void testSetId() {
        Long oldId = ingredient1.getId();
        Long newId = oldId + 5;
        ingredient1.setId(newId);
        assertEquals(ingredient1.getId(), newId);
    }


    /**
     * Test of getName method, of class Ingredient.
     */
    @Test
    public void testGetName() {
        assertEquals(ingredient1.getName(), name1);
    }


    /**
     * Test of setName method, of class Ingredient.
     */
    @Test
    public void testSetName() {
        ingredient1.setName(name2);
        assertEquals(ingredient1.getName(), name2);
    }

}
