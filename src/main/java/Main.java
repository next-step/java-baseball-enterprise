import numberbaseball.NumberBaseball;
import numberbaseballimpl.NumberBaseballImpl;

public class Main {

    public static void main(String[] args) {
        NumberBaseball numberBaseball = NumberBaseballImpl.create();
        numberBaseball.playGame();
    }
}
