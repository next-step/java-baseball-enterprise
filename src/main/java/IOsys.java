import java.util.Scanner;

public class IOsys {
    private Scanner sc;

    public IOsys(){
        sc = new Scanner(System.in);
    }
    public int userIn(){
        System.out.print("숫자를 입력해주세요: ");
        int userinput = sc.nextInt();
        while(userinput < 100 || 1000 <= userinput || check_dup(userinput)){
            System.out.println("불가능한 입력입니다.");
            System.out.print("숫자를 입력해주세요: ");
            userinput = sc.nextInt();
        }
        return userinput;
    }

    public boolean check_dup(int userinput){
        return userinput/100 == userinput%10 || userinput/100 == userinput%100/10 || userinput%10 == userinput%100/10;
    }

    public void print_result(Checker C){
        if(C.getStrike()!= 0) System.out.printf("%d스트라이크 ", C.getStrike());
        if(C.getBall() != 0) System.out.printf("%d볼 ", C.getBall());
        if(C.getBall() + C.getStrike() == 0) System.out.printf("낫싱");
        System.out.println();
    }
    public int nextgame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int ContinueFlag = sc.nextInt();

        return ContinueFlag;
    }
}
