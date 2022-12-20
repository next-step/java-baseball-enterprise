import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Message {
    INPUT_MSG("숫자를 입력해주세요 : "),
    END_MSG("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_MSG("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"),
    INVALID_INPUT_WARNING("잘못된 입력입니다.");

    private final String msgStr;
}
