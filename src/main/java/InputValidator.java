public class InputValidator {
    public boolean validate(String input){
        //input 문자열의 길이 검사
        if(input.length() != 3){
            System.out.println(Message.INVALID_INPUT_WARNING.getMsgStr());
            return false;
        }

        //input 문자열에 0이 포함되어 있는지 검사
        if(input.contains("0")) return false;

        //input 문자열이 숫자로만 이루어져 있는지 검사
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            System.err.println(Message.INVALID_INPUT_WARNING.getMsgStr());
            return false;
        }

        return true;
    };
}
