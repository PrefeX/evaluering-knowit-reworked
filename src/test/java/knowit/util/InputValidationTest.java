package knowit.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


/**
 *
 * @author Christian
 */
public class InputValidationTest {

    /**
     * Test of isNullOrEmpty method, of class InputValidation.
     */
    @Test
    public void testIsNullOrEmpty() {
        String input = null;
        assertTrue(InputValidation.isNullOrEmpty(input));
    }


    /**
     * Test of isNullOrEmpty method, of class InputValidation.
     */
    @Test
    public void testIsNullOrEmpty2() {
        String input = "   ";
        assertTrue(InputValidation.isNullOrEmpty(input));
    }


    /**
     * Test of isNullOrEmpty method, of class InputValidation.
     */
    @Test
    public void testIsNullOrEmpty3() {
        String input = "";
        assertTrue(InputValidation.isNullOrEmpty(input));
    }


    /**
     * Test of isNullOrEmpty method, of class InputValidation.
     */
    @Test
    public void testIsNullOrEmpty4() {
        String input = "Text";
        assertFalse(InputValidation.isNullOrEmpty(input));
    }

}
