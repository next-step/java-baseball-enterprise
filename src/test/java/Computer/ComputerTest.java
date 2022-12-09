package Computer;

import User.User;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class ComputerTest {
    @Test
    void initiateNumberTest(){
        Computer computer = new Computer();

        assertThat(computer.setNumber()).isEqualTo(3);
    }

    @Test
    void getResultTest(){
        Computer computer = new Computer();
        computer.setNumber();

        User user=new User();
        user.setNumbers("321");

        int[] result = computer.getBallStrike(user.getNumbers());

        assertThat(result[0]).isEqualTo(getBall(computer.getTargetNumbers(),user.getNumbers()));
        assertThat(result[1]).isEqualTo(getStrike(computer.getTargetNumbers(),user.getNumbers()));
    }

    int getBall(List<Integer> computerNumbers, List<Integer> userNumbers){
        boolean[] used=new boolean[10];
        Arrays.fill(used, false);

        for(Integer i : computerNumbers){
            used[i] = true;
        }

        int ball = 0;
        for(Integer i : userNumbers){
            ball += used[i] ? 1 : 0;
        }

        return ball;
    }
    int getStrike(List<Integer> computerNumbers, List<Integer> userNumbers){
        int size = computerNumbers.size();
        int strike=0;

        for(int i=0; i<size; i++){
            strike += computerNumbers.get(i).equals(userNumbers.get(i)) ? 1 : 0;
        }

        return strike;
    }
}
