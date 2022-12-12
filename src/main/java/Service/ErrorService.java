package Service;

import Repository.GameRepository;

import static util.Message.*;

public class ErrorService {

    public GameRepository gameRepository;

    public ErrorService(GameRepository gameRepository) {
        this.gameRepository = gameRepository; // GameService의 GameRepository를 받아와야한다. (싱글톤 패턴 구현 방식)
    }

    public boolean checkUserInputNumber(){
        // 3개의 Error 검증 로직에서 하나라도 false 라면 false 반환
        boolean check = (inputErrorNotEqualSize() && inputErrorNotInArrange()) && inputErrorDuplicateNumber();
        return check;
    }

    public boolean inputErrorNotEqualSize(){ // 사용자 입력이 3자리수가 아닌지 확인한다.
        String userNumber = gameRepository.getUserNumber();
        if(userNumber.length() != 3) {
            System.out.println(ERROR_INPUT_SIZE.getMessage());
            return false;
        }
        return true;
    }

    public boolean isInArrange(char c){
        if('1' <= c && c <= '9') return true;
        return false;
    }
    public boolean inputErrorNotInArrange(){ // 사용자 입력의 각 숫자가 1 ~ 9 사이인지 확인한다.
        String userNumber = gameRepository.getUserNumber();
        Boolean checkArrange = true;
        for(int i=0; i<3; i++){
            checkArrange = checkArrange && isInArrange(userNumber.charAt(i));
        }
        if(!checkArrange) {
            System.out.println(ERROR_INPUT_ARRANGE.getMessage());
            return false;
        }
        return true;
    }

    public boolean checkDuplicate(String userNumber){
        if(userNumber.charAt(0) == userNumber.charAt(1)) return false;
        if(userNumber.charAt(0) == userNumber.charAt(2)) return false;
        if(userNumber.charAt(1) == userNumber.charAt(2)) return false;
        return true;
    }

    public boolean inputErrorDuplicateNumber(){ // 사용자 입력에 중복된 숫자가 있는지 확인한다.
        String userNumber = gameRepository.getUserNumber();
        if(!checkDuplicate(userNumber)) {
            System.out.println(ERROR_INPUT_DUPLICATE.getMessage());
            return false;
        }
        return true;
    }

    public boolean checkRestartCount(String restartCount){ // 재시작 카운트에 대한 예외 처리
        if(restartCount.equals("1") || restartCount.equals("2")) return true;
        System.out.println(ERROR_INPUT_RESTART.getMessage());
        return false;
    }
}
