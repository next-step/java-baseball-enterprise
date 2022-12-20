package NumberBaseball.Functions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Number_MatchingTest {
    Number_Matching number_matching;
    private Integer letter;

    @BeforeEach
    public void init(){
        this.letter = 3;
        number_matching = new Number_Matching(this.letter);
    }

    @Test
    public void ball0_strike0(){
        List<Integer> res = number_matching.matching_two_numbers("122", "567");
        assertThat(res.get(0)).isEqualTo(0);
        assertThat(res.get(1)).isEqualTo(0);
    }

    @Test
    public void balln_strike0(){
        List<Integer> res = number_matching.matching_two_numbers("122", "244");
        assertThat(res.get(0)).isEqualTo(1);
        assertThat(res.get(1)).isEqualTo(0);
    }

    @Test
    public void ball0_striken(){
        List<Integer> res = number_matching.matching_two_numbers("122", "124");
        assertThat(res.get(0)).isEqualTo(0);
        assertThat(res.get(1)).isEqualTo(2);
    }


    @Test
    public void balln_striken(){
        List<Integer> res = number_matching.matching_two_numbers("122", "223");
        assertThat(res.get(0)).isEqualTo(1);
        assertThat(res.get(1)).isEqualTo(1);
    }

    @Test
    public void all_strike(){
        boolean res = number_matching.chk_strike("122", "122");
        assertThat(res).isTrue();
    }
}