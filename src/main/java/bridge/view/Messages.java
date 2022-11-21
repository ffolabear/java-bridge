package bridge.view;

public enum Messages {

    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH_MESSAGE("\n다리의 길이를 입력해주세요."),
    INPUT_GAME_COMMAND_MESSAGE("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_RETRY_MESSAGE("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT_TITLE("\n최종 게임 결과"),
    GAME_RESULT_MESSAGE("\n게임 성공 여부: %s"),
    GAME_TRIAL_MESSAGE("총 시도한 횟수: %s");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
