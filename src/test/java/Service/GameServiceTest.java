package Service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
}