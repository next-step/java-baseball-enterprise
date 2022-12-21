public class GameInputValidator {
    public boolean validateGameInput(String input){
        //input 문자열의 길이 & 0이 포함되어 있는지 검사
        if(input.length() != 3 || input.contains("0")){
            System.out.println(Message.INVALID_INPUT_WARNING.getMsgStr());
            return false;
        }

        return isNumber(input);
    };

    //input 문자열이 숫자로만 이루어져 있는지 검사
    public boolean isNumber(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            System.out.println(Message.INVALID_INPUT_WARNING.getMsgStr());
            return false;
        }

        return true;
    }

    public boolean validateRestartInput(String input) {
        if(!isNumber(input)){
            System.out.println(Message.INVALID_INPUT_WARNING.getMsgStr());
            return false;
        }

        int n = Integer.parseInt(input);
        if(n != 1 && n != 2){
            System.out.println(Message.INVALID_INPUT_WARNING.getMsgStr());
            return false;
        }

        return true;
    }

}
