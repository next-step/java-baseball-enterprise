import java.util.HashMap;

public class Answer {

    /*
     * key: 정답 숫자, value: 정답 숫자의 index
     * 예) 정답 숫자가 567인 경우: {5=0, 6=1, 7=2}
     */
    private final HashMap<Integer, Integer> answerMap = new HashMap<>();
    private int idx = 0;

    public Answer() {
        setAnswer();
    }

    public HashMap<Integer, Integer> getAnswerMap() {
        return answerMap;
    }

    /*
     * 정답 숫자 조합을 재설정함. 게임 재시작시 사용.
     */
    public void resetAnswer() {
        answerMap.clear();
        idx = 0;
        setAnswer();
    }

    /*
     * answerMap에 특정 숫자가 포함돼있는지 확인
     */
    public boolean contains(int num) {
        if (answerMap.containsKey(num)) {
            return true;
        }
        return false;
    }

    /*
     * answerMap에 포함된 숫자의 index값(몇 번째 정답숫자인지)을 확인
     */
    public Integer getIndex(int num) {
        return answerMap.get(num);
    }

    /*
     * 3개의 중복되지 않는 숫자를 답으로 선택하여 answerMap에 추가.
     */
    private void setAnswer() {
        while (answerMap.size() < 3) {
            addAnswerNumber();
        }
    }

    /*
     * 임의의 숫자를 하나 뽑는다.
     * 이미 답으로 선택된 숫자가 아니면 answerMap에 추가.
     */
    private void addAnswerNumber() {
        int num = pickNumber();
        if (isUnique(num)) {
            answerMap.put(num, idx++);
        }
    }

    /*
     * 1~9 사이의 임의의 숫자를 뽑아 리턴.
     */
    private int pickNumber() {
        int num = 0;
        while (num == 0) {
            num = (int) (Math.random() * 10);
        }
        return num;
    }

    /*
     * 인수로 받은 숫자가 이미 answerMap에 포함됐는지 확인.
     * 존재하지 않는 숫자라면 true, 이미 존재하는 숫자라면 false 리턴.
     */
    private boolean isUnique(int num) {
        if (answerMap.containsKey(num)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return answerMap.toString();
    }
}
