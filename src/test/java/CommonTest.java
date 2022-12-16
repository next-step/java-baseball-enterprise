import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommonTest {

    private final Common common = new Common();

    @Test
    void validationTest(){
        assertFalse(common.validation("122"));      // 뒷 두 자리 테스트
        assertFalse(common.validation("0123"));     // 4자리, 0 포함
        assertFalse(common.validation("113"));      // 앞 두 자리 테스트
        assertFalse(common.validation("103"));      // 0 포함 테스트
        assertFalse(common.validation("979"));      // 연속x 중복 o
        assertTrue(common.validation("475"));       // 통과
        assertTrue(common.validation("123"));       //통과
    }
}

