package num3baseball.ui;

import num3baseball.dataobject.TrialResult;

import java.util.ArrayList;

public interface GameUserInterface {
    public ArrayList<Integer> inputNumbers(); // input을 받아 ArrayList<Integer>로 반환
    public void printResult(TrialResult res); // TrialResult 객체를 받아 strike, ball을 출력
    public void printError(Exception e); // Exception e에 따라 여러 가지의 에러 문구 표시
    public void printGameClear(int size); // 게임을 통과하였을 시에 출력
    public boolean printRetry(); // 다시 하시겠습니까? 출력
}
