import domain.BallNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RandomBallNumberGeneratorTest {

    @Test
    @DisplayName("랜덤으로 생성한 숫자 테스트")
    void generateRandomBallNumber(){
        //given
        RandomBallNumberGenerator randomBallNumberGenerator = new RandomBallNumberGenerator();
        int length = 3;

        //when
        BallNumber ballNumber = randomBallNumberGenerator.generate(length);

        //then
        // 길이 일치
        assertEquals(ballNumber.getLength(),length);
        // 중복 없음
        assertEquals(new HashSet<>(ballNumber.getDigits()).size(), length);
    }
}
