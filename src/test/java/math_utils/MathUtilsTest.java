package math_utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    public void testAdd() {
        MathUtils math = new MathUtils();
        assertEquals(6, math.add(2, 3), "2 + 3 phải bằng 5");
    }
}