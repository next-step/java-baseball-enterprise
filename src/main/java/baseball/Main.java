package baseball;
import baseball.view.BaseballView;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        BaseballView baseballView = new BaseballView();

        try {
            List<Integer> playerBaseballNumber = baseballView.getPlayerBaseballNumber();
            System.out.println(playerBaseballNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
