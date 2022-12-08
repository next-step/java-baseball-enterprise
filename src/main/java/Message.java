public enum Message {
    INPUT_MSG("숫자를 입력해주세요 : "),
    END_MSG("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INVALID_INPUT_WARNING("잘못된 입력입니다.");

    private String Message;
    Message(String message){
        this.Message = message;
    }
}
