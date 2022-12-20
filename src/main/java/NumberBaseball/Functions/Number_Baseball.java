package NumberBaseball.Functions;


public class Number_Baseball {
    private String computer_number;
    private String user_number;
    private boolean isEnd;
    private Integer letter;

    Create_Random_Number create_random_number;
    Create_User_Number create_user_number;
    Number_Matching number_matching;

    public Number_Baseball() {
        this.computer_number = "";
        this.user_number = "";
        this.isEnd = false;
        this.letter = 3;
        create_random_number = new Create_Random_Number(this.letter);
        create_user_number = new Create_User_Number();
        number_matching = new Number_Matching();
    }

    public void Start_Game(){
        this.computer_number = create_random_number.set_random_number();
        while (!this.isEnd) {
            this.user_number = create_user_number.Create_User_Number();
            this.isEnd = number_matching.chk_strike(this.computer_number, this.user_number);
        }
        System.out.println("3 Strike: 게임을 종료합니다");
    }
}