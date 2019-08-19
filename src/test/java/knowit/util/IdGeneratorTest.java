package knowit.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class IdGeneratorTest {

    @Test
    public void testGenerateId() {
        Long value1 = IdGenerator.generateId();
        Long value2 = IdGenerator.generateId();
        assertTrue((value1 < value2));
    }

}
