import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommonTest {

    @Test
    void validationTest(){
        assertFalse(Common.validation("122"));      // 뒷 두 자리 테스트
        assertFalse(Common.validation("0123"));     // 4자리, 0 포함
        assertFalse(Common.validation("113"));      // 앞 두 자리 테스트
        assertFalse(Common.validation("103"));      // 0 포함 테스트
        assertFalse(Common.validation("979"));      // 연속x 중복 o
        assertTrue(Common.validation("475"));       // 통과
        assertTrue(Common.validation("123"));       //통과
    }
}

