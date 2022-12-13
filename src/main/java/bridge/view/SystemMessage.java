package bridge.view;

public enum SystemMessage {

    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: %s, 아래: %s)"),
    INPUT_RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
