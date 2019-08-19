package knowit.util;


/**
 * A collection of validation utilities
 *
 * @author Christian
 */
public class InputValidation {

    /**
     * Check if a string is {@code null}, empty or only contains spaces.
     *
     * @param input The string we want to check
     * @return Returns {@code true} if the value is {@code null} or empty. If
     * not, it returns true.
     */
    public static boolean isNullOrEmpty(String input) {
        return (input == null || input.replace(" ", "").isEmpty());
    }
}
