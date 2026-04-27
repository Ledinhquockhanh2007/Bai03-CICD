package math_utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    public void testAdd() {
        MathUtils math = new MathUtils();
        // CỐ TÌNH GÂY LỖI Ở ĐÂY ĐỂ HOÀN THÀNH YÊU CẦU ĐỀ BÀI
        // (Sửa số 5 thành số 6 để test CI bị tạch)
        assertEquals(5, math.add(2, 3), "2 + 3 phải bằng 5");
    }
}