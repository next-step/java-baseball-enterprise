import java.util.ArrayList;

public class Answer {
    
    private ArrayList<Integer> answerList = new ArrayList<>();

    public Answer() {
        setAnswer();
    }

    public ArrayList<Integer> getAnswerList() {
        return answerList;
    }

    /*
     * 3개의 중복되지 않는 숫자를 답으로 선택하여 answer 리스트에 추가.
     */
    public void setAnswer() {
        while (answerList.size() < 3) {
            addAnswerNumber();
        }
    }

    /*
     * 임의의 숫자를 하나 뽑는다.
     * 이미 답으로 선택된 숫자가 아니면 answerList에 추가.
     */
    public void addAnswerNumber() {
        int num = pickNumber();
        if (validateDuplication(num)) {
            answerList.add(num);
        };
    }

    /*
     * 1~9 사이의 임의의 숫자를 뽑아 리턴.
     */
    public int pickNumber() {
        int pickNum = 0;
        while (pickNum == 0) {
            pickNum = (int) (Math.random() * 10);
        }
        return pickNum;
    }

    /*
     * 인수로 받은 숫자가 이미 answerList에 포함됐는지 확인.
     * 중복이 있을 시 false, 없을 시 true 리턴.
     */
    public boolean validateDuplication(int num) {
        if (answerList.contains(num)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return answerList.toString();
    }   
}
