package NumberBaseball.Functions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Create_Random_NumberTest {
    Create_Random_Number create_random_number;
    private Integer letter;

    @BeforeEach
    void init(){
        this.letter = 3;
        create_random_number = new Create_Random_Number(this.letter);
    }

    @Test
    public void random_number_range(){
        String value = create_random_number.set_random_number();
        assertThat(value.length()).isEqualTo(this.letter);
        for (int i=0; i < this.letter; i++){
            int transform_to_int = Character.getNumericValue(value.charAt(i));
            assertThat(transform_to_int).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }
    }
}