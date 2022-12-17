package view;

import config.GlobalData;
import domain.ballnumber.BallNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class InputView {

    private BufferedReader br;

    public InputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public BallNumber inputGuessedBallNumber() throws Exception{
        System.out.print("숫자를 입력해주세요 : ");
        String input = br.readLine();
        validateBallNumberInput(input);
        return new BallNumber(stringToIntList(input));
    }

    public void validateBallNumberInput(String input) {
        if(input.length()!= GlobalData.BALL_NUMBER_LENGTH)
            throw new IllegalArgumentException(GlobalData.BALL_NUMBER_LENGTH+" 자리 숫자를 입력해주세요.");
        Set<Character> numberSet = new HashSet<>();
        for(char c : input.toCharArray()) {
            validateBallNumberChar(c);
            numberSet.add(c);
        }
        if(numberSet.size()!=GlobalData.BALL_NUMBER_LENGTH)
            throw new IllegalArgumentException("숫자는 중복되지 않습니다.");
    }

    public void validateBallNumberChar(char c) {
        if(c<'1' || c>'9') throw new IllegalArgumentException("각 자리는 1 이상 9 이하의 숫자로 이루어져야 합니다.");
    }

    public List<Integer> stringToIntList(String input) {
        List<Integer> result = new ArrayList<>();
        for(char c : input.toCharArray()) {
            result.add(c-'0');
        }
        return result;
    }

}
