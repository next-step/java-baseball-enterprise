package Service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    public GameService gameService;

    public GameServiceTest() {
        this.gameService = new GameService();
    }

    public void putStringToInputStream(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("사용자가 입력한 내용이 제대로 저장이 되었는가?")
    void userInputTest(){
        // 사용자 입력을 받는 테스트
        putStringToInputStream("UserInput");
        gameService.getInputNumbers();

        assertThat(gameService.gameRepository.getUserNumber()).isEqualTo("UserInput");
    }

    @Test
    @DisplayName("사용자 입력 에러가 제대로 검출 되는가?")
    void userInputErrorTest(){
        putStringToInputStream("abc"); // input을 바꿔가며 에러 테스트를 진행한다.
        gameService.getInputNumbers();

        boolean errorFlag = gameService.checkUserInputNumbers();

        assertThat(errorFlag).isFalse();
    }

    @Test
    @DisplayName("사용자 입력과 정답이 제대로 비교되는가?")
    void compareTest(){
        ArrayList<Integer> cmp = new ArrayList<>();
        cmp.add(1); cmp.add(2); cmp.add(3);
        gameService.gameRepository.numbers = cmp;           // 기준 값 설정 (123)

        gameService.gameRepository.setUserNumber("123");    // 테스트 원하는 값으로 설정하기

        boolean result = gameService.compareWithAnswer();

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("재시작 카운트가 제대로 작동하는가?")
    void restartTest(){
        putStringToInputStream("2"); // 1 -> 게임 재시작, 2 -> 게임 종료

        boolean result = gameService.endAndRestartGame(true);

        assertThat(result).isTrue(); // 게임 종료 = true
    }
}