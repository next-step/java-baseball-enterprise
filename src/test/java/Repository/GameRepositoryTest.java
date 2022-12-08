package Repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class GameRepositoryTest {

    public GameRepository gameRepository;

    public GameRepositoryTest() {
        this.gameRepository = new GameRepository();
    }

    public boolean checkDuplicate(ArrayList<Integer> numbers){
        if(numbers.get(0) == numbers.get(1)) return false;
        if(numbers.get(0) == numbers.get(2)) return false;
        if(numbers.get(1) == numbers.get(2)) return false;
        return true;
    }

    public boolean checkArrange(int num){
        if(1 <= num && num <= 9) return true;
        return false;
    }

    @Test
    @DisplayName("생성된 난수가 3자리인가?")
    void checkSize(){
        ArrayList<Integer> numbers = gameRepository.getNumbers();

        // 3자리인지
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성된 난수 3자리 모두 중복이 없는가?")
    void checkDuplicateInNumbers(){
        ArrayList<Integer> numbers = gameRepository.getNumbers();

        // 3자리 모두 중복이 없는지
        assertThat(checkDuplicate(numbers)).isTrue();
    }

    @Test
    @DisplayName("생성된 난수 3자리 모두 중복이 없는가?")
    void checkNumbersArrange(){
        ArrayList<Integer> numbers = gameRepository.getNumbers();

        // 3자리 수 모두 1~9 범위 안에 있는지
        for(int i=0; i<3; i++){
            assertThat(checkArrange(numbers.get(i))).isTrue();
        }
    }
}