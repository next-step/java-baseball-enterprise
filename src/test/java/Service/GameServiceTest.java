package Service;

import domain.Computer;
import domain.Score;
import domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.GameService;
import service.GameServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest {

    @Test
    @DisplayName("볼 확인")
    public void isBall(){
        GameService gameService = new GameServiceImpl();
        Score score = new Score();
        gameService.compareNumber(new ArrayList<>(Arrays.asList(7, 1, 3)), 7, 1, score);
        String actual = score.getScore();
        assertThat(actual).isEqualTo("1 볼");
    }

    @Test
    @DisplayName("스트라이크 확인")
    public void isStrike(){
        GameService gameService = new GameServiceImpl();
        Score score = new Score();
        gameService.compareNumber(new ArrayList<>(Arrays.asList(7, 1, 3)), 7, 0, score);
        String actual = score.getScore();
        assertThat(actual).isEqualTo("1 스트라이크");
    }

    @ParameterizedTest
    @DisplayName("점수 확인")
    @CsvSource(value = {"124;1 볼",
            "214;1 스트라이크",
            "173;1 스트라이크 2 볼",
            "245;낫싱",
            "713;3 스트라이크",}, delimiter = ';')
    public void checkScore(String input,String expected){
        GameService gameService = new GameServiceImpl();
        Computer computer = new Computer(new ArrayList<>(Arrays.asList(7, 1, 3)));
        User user = new User();
        user.setNumbers(input);
        Score score = new Score();
        gameService.compareNumbers(computer, user, score);
        String actual = score.getScore();
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자 입력 테스트")
    @CsvSource(value = {"123;[1, 2, 3]",
            "112;숫자를 입력해주세요 : 잘못된 입력입니다.",
            "1234;숫자를 입력해주세요 : 잘못된 입력입니다.",
            "a12;숫자를 입력해주세요 : 잘못된 입력입니다."}, delimiter = ';')
    void testInput(String input,String expected) throws IOException {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        User user = new User();
        GameService gameService = new GameServiceImpl();
        String actual;

        systemIn(input);
        gameService.userInput(user);
        actual = user.getNumbers().toString();

        if (user.getNumbers().isEmpty()){
            actual = out.toString().trim();
        }
        assertThat(actual).isEqualTo(expected);

    }

    @ParameterizedTest
    @DisplayName("플레이 테스트")
    @CsvSource(value = {"123;숫자를 입력해주세요 : 1 스트라이크 1 볼",
            "145;숫자를 입력해주세요 : 1 볼",
            "671;숫자를 입력해주세요 : 2 볼",
            "216;숫자를 입력해주세요 : 1 스트라이크",
            "713;숫자를 입력해주세요 : 3 스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"}, delimiter = ';')
    void testPlay(String input, String expected)throws IOException {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Computer computer = new Computer(new ArrayList<>(Arrays.asList(7, 1, 3)));
        User user = new User();
        Score score = new Score();
        GameService gameService = new GameServiceImpl();

        systemIn(input);

        gameService.playGame(computer, user, score);

        String actual = out.toString().trim();
        assertThat(actual).contains(expected);

    }


    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
