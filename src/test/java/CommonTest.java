import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommonTest {

    private final Common common = new Common();

    @Test
    void validationTest(){
        assertFalse(common.validation("0123"));
        assertFalse(common.validation("111"));
        assertFalse(common.validation("103"));
        assertFalse(common.validation("979"));
        assertTrue(common.validation("475"));
        assertTrue(common.validation("123"));
    }
}

