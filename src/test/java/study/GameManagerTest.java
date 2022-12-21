package study;

import num3baseball.dataobject.NumBallsNBalls;
import num3baseball.manager.GameManager;
import num3baseball.ui.GameUserInterface;
import num3baseball.ui.GameUserInterfaceTestStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    private ArrayList<Integer> numToArrayList(int num){
        ArrayList<Integer> res = new ArrayList<>();
        while(num>0){
            res.add(0,num%10);
            num /= 10;
        }
        return res;
    }
    @Test
    @DisplayName("WholeGameProcess")
    public void test1() {
        int startNum = 123;
        GameUserInterfaceTestStub gameUIStub = new GameUserInterfaceTestStub();
        GameManager gameManager = new GameManager(gameUIStub,
                new NumBallsNBalls(numToArrayList(startNum)), 3);

        int[] trial = {147, 258, 369, 159, 138, 132, 123};
        int[] sb = {10, 1, 1, 10, 11, 12, 30};

        int size = trial.length;
        for (int i = 0; i < size; i++) {
            gameUIStub.inputNumbers(numToArrayList(trial[i]));
            boolean isEnd = gameManager.executeOneCycle();
            assertThat(gameUIStub.res.getStrike()).isEqualTo(sb[i] / 10);
            assertThat(gameUIStub.res.getBall()).isEqualTo(sb[i] % 10);
            assertThat(isEnd).isEqualTo(gameUIStub.res.getStrike()==3);
        }
    }
}
