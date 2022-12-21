# README.md

## 구현 기능

1.  1~9까지 서로 다른 수로 이루어진 3자리의 수를 생성한다.
- java.util의 random 클래스 활용
- hashSet을 활용해 중복 숫자 생성 방지

1.  3자리 숫자를 입력받고 입력 값을 검증한다.
- 3자리인지 검사
- 숫자인지 검사
- 중복된 숫자 없는 지 검사

1.  정답과 입력받은 숫자를 비교해서 결과를 출력한다.
- 위치, 수가 일치하면 Strike
- 수만 일치하면 Ball
- 3Strike → 정답 처리
- 0Strike 0Ball → 낫싱 처리

4. 정답을 맞추면 게임을 다시 시작하거나, 완전히 종료할 수 있도록 처리한다.

- y 입력하면 게임 계속
- n 입력하면 게임 중단

## 기능별 핵심 로직 코드

---

1. 1~9까지 서로 다른 수로 이루어진 3자리의 수를 생성한다.

    ```java
    private String generateAnswer() {
            Set<Integer> hashSet = new HashSet<Integer>(); // 중복 숫자 생성 방지를 위한 HashSet
            String numbers = "";
            for (int i =0; i<DIGITS; i++) {
                numbers += generateNumber(hashSet); // 지정된 자리수(3)만큼 숫자 생성
            }
    
            return numbers;
        }
    
        private String generateNumber(Set<Integer> hashSet) {
            Random random = new Random();
            int phase = hashSet.size();
            int randomNum = -1;
            while (phase == hashSet.size()) { // 원래 hashSet의 크기가 달라지지 않았다면 반복
                randomNum = random.nextInt(8) + 1; // 1 ~ 9까지의 숫자 1개 추출
                hashSet.add(randomNum);
            }
            return Integer.toString(randomNum);
        }
    ```


2. 3자리 숫자를 입력받고 입력 값을 검증한다.

    ```java
    public String getUserInput() {
            System.out.print("숫자를 입력해주세요: ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            validateUserInput(userInput); // 입력값 검증
            return userInput;
        }
    
        private boolean validateUserInput(String userInput) {
            if (!validate_length(userInput)) { // 길이 검증
                throw new IllegalArgumentException("입력이 3자리가 아닙니다.");
            }
            else if (!validate_consistOfNumbers(userInput)) { // 숫자 구성 검증
                throw new IllegalArgumentException("입력이 숫자로 구성돼있지 않습니다.");
            }
            else if (!validate_duplicateNumbers(userInput)) { // 중복 숫자 검증
                throw new IllegalArgumentException("중복된 숫자가 입력됐습니다.");
            }
            return true;
        }
    
        private boolean validate_duplicateNumbers(String userInput) {
            Set<Character> hashSet = new HashSet<Character>();
            for(int i =0; i<userInput.length(); i++) {
                hashSet.add(userInput.charAt(i));
            }
            return hashSet.size() == DIGITS;
        }
    
        private boolean validate_length(String UserInput) {
            return UserInput.length() == DIGITS;
        }
        private boolean validate_consistOfNumbers(String userInput) {
    
            int flag = 1;
            for(int i = 0; i < userInput.length(); i++) {
                flag *= validate_number(userInput.charAt(i)); // 각 자리수마다 숫자로 이루어졌는 지 검증
            }
            return flag == 1;
        }
        private int validate_number(char c) {
            if (c >= '1' && c <= '9')
                return 1;
            return 0;
        }
    ```

3. 정답과 입력받은 숫자를 비교해서 결과를 출력한다.

    ```java
    public GameResultSet proceedRound() {
            Set<Character> hashSet = generateAnswerSet();
            GameResultSet resultSet = new GameResultSet();
            try{
                String userInput = getUserInput();
                judgeNumbers(userInput, hashSet, resultSet);
                printScore(resultSet);
            }catch(IllegalArgumentException e) {
                System.out.println(e);
            }
            return resultSet;
        }
    
        private void judgeNumbers(String userInput, Set<Character> hashSet, GameResultSet resultSet) {
            for (int i = 0; i < userInput.length(); i++) {
                judgeOneNumber(userInput.charAt(i), answer.charAt(i), hashSet, resultSet);
            }
        }
    
        private Set<Character> generateAnswerSet() {
            Set<Character> hashSet = new HashSet<Character>();
            for (int i = 0; i < answer.length(); i++) {
                hashSet.add(answer.charAt(i));
            }
            return hashSet;
        }
    
        private void judgeOneNumber(char ui, char aw, Set<Character> hashSet, GameResultSet resultSet) {
            if (ui == aw) {
                resultSet.strike += 1;
            }
            else if (hashSet.contains(ui)) {
                resultSet.ball += 1;
            }
        }
    
    private void printScore(GameResultSet resultSet) {
          if (resultSet.strike == 0 && resultSet.ball == 0) {
              System.out.println("낫싱");
          }
          else if (resultSet.strike == 0) {
              System.out.println(resultSet.ball + "볼");
          }
          else if (resultSet.ball == 0) {
              System.out.println(resultSet.strike + "스트라이크");
          }
          else if (resultSet.strike != 0 && resultSet.ball != 0) {
              System.out.println(resultSet.strike + "스트라이크 " + resultSet.ball + "볼");
          }
      }
    ```
    
    ```java
    public class GameResultSet {
        public int strike;
        public int ball;
    
        public GameResultSet() {
            this.strike = 0;
            this.ball = 0;
        }
    
        public GameResultSet(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }
    }
    ```

4. 정답을 맞추면 게임을 다시 시작하거나, 완전히 종료할 수 있도록 처리한다.

    ```java
    public void play() {
        boolean flag = true;
        while(flag) {
            flag = playGame();
            answer = generateAnswer();
        }
    }
    
    private boolean playGame() {
        GameResultSet resultSet = new GameResultSet();
        while(!(resultSet.strike == DIGITS && resultSet.ball == 0)) {
            resultSet = proceedRound();
        }
        boolean flag = continueGame();
        return flag;
    }
    
    private boolean continueGame() {
        System.out.println("게임을 계속 계속하시겠습니까? (y / n)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if( input.equals("y") || input.equals("Y")) {
            return true;
        }
        return false;
    }
    ```

## 개발하면서 생긴 궁금증

---

1. private 속성 Junit으로 검증하기
    - 처음에 숫자를 만들 때 private 인스턴스 변수로 만들려고 하는데 JUnit으로 어떻게 검증을 할 수 있을까?

      → getDeclaredField 속성을 통해 값 얻을 수 있음

2. 최대 depth 1인 것 관련
    - 3자리 랜덤 숫자를 생성하려면 숫자를 하나 만들때마다 이전에 만든 숫자와 겹치는지 확인하는 로직이 필요함. 그런데 그러려면 `반복문 + 조건문`이 필요한데 그럼 depth 2가 되버린다..

      → hashSet을 통해 add했을 때 사이즈가 증가했는 지 여부를 반복문의 조건으로 넣어버려서 해결 (`phase == hashSet.size()`)

3. Test Class에서 생성자 활용 문제
    - 정답 숫자를 만들고 검증하는 과정에서 여러 테스트 메서드가 있는데, 객체를 생성하고 privte field를 가져오는 과정의 코드가 중복이 발생해서 이를 테스트 클래스의 생성자에서 인스턴스를 생성해줌으로써 중복을 해결했다.
    - 하지만 Test Class에서 생성자를 활용하는 것이 좋은 방법인 지는 잘 모르겠다.

1. JUnit Test Method에서는 userInput을 받지 못하는 문제
    - 전체 로직을 테스트하려면 user input을 매번 받아야 하는데, Test는 Input을 받는 기능을 지원하지 않는다.
    - Input에 따라 테스트 결과가 달라지며, CI/CD 환경을 구축하려면 Input을 받는 테스트는 지원할 수 없기 때문인 것 같다.
    - 일단은 Game 클래스에 main메서드로 게임을 실행했다.
    - 다른 사람들은 어떻게 Test했는지 물어봐야겠다.

## JUnit관련 새로 알게된 점

---

- @RepeatedTest를 통해 한 테스트 메서드를 여러번 반복실행할 수 있다.
    - 정답 생성 로직에서 랜덤으로 생성되는 숫자가 정답이 될 수 있는 수인지 검증하는 과정에서 반복적으로 테스트할 필요가 있다.
    - 이를 어노테이션을 통해 반복해서 테스트할 수 있다.
- @ParameterizedTest를 통해 테스트메서드의 파라미터에 특정 값을 넣어서 테스트를 진행할 수 있다.
    - @ValueSource를 활용하면 파라미터에 들어갈 값을 배열 형태로 넣을 수 있다.

        ```
        @ParameterizedTest
            @ValueSource(strings = {"01", "dsada", "dw", "fwqf", "\n", " ", "d"})
        ```



## 느낀점

---

- 사전과제를 수행하며 메서드당 10줄 이내, depth 2 미만으로 작성하는 것이 어려워서 지키지 못했다.
- 피드백을 받을 때 다른 크루들의 코드를 봐서 참고해서 다시 수정해봐야겠다는 생각을 했다.
- TDD를 활용해서 프로그램을 만들었는데 테스트를 어떤 범위로 해야하는 지 아직 개념이 명확하지 않다고 느꼈다.
- Input을 받아서 테스트해야하는 경우에도 어떻게 테스트를 진행해야 하는 지 아직 개념이 명확하지 않다.
- 여러 미팅을 진행하며 새로운 용어를 많이 알게됐다. 위키를 참고해서 더 공부해야겠다는 생각을 했다.