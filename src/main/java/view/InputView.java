package view;

import domain.BallNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InputView {

    private BufferedReader br;

    public InputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public BallNumber inputGuessedBallNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = "";
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 유효성 검사 구간
        return new BallNumber(stringToIntList(input));
    }

    public List<Integer> stringToIntList(String input) {
        List<Integer> result = new ArrayList<>();
        for(char c : input.toCharArray()) {
            result.add(c-'0');
        }
        return result;
    }

}
