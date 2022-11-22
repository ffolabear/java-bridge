package bridge.view;

public enum Errors {

    ERROR_HEAD("[ERROR] "),
    ERROR_NON_DIGIT("다리 길이는 반드시 숫자여야 합니다."),
    ERROR_EMPTY_INPUT("입력값을 입력하지 않았습니다."),
    ERROR_EXCESS_INTEGER("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_INVALID_BRIDGE_LENGTH("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_INVALID_GAME_COMMAND("유효하지 않은 명령어입니다."),
    ERROR_INVALID_REPLAY_COMMAND("유효하지 않은 명령어입니다."),
    ERROR_EXCESS_MAXIMUM_TRIAL("게임의 최대 시도 횟수를 초과하였습니다.");

    private final String error;

    Errors(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
