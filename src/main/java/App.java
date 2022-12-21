import baseball.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean continueGame;

        // app start
		Baseball game = new BaseballImpl();
		do{
			game.start();
			System.out.print("계속 하시겠습니까? (y/n) : ");
			String command = sc.nextLine();
			continueGame = command.charAt(0) == 'y' || command.charAt(0) == 'Y';
		} while (continueGame);
    }
}
