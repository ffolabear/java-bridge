package bridge.view;

public enum Errors {

    ERROR_HEAD("[ERROR] "),
    ERROR_DIGIT("다리 길이는 숫자만 입력 가능합니다."),
    ERROR_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_INVALID_MOVE("유효하지 않은 이동 명령어 입니다.");

    private final String error;

    Errors(String error) {
        this.error = error;
    }


    public String getError() {
        return Errors.ERROR_HEAD.error + error;
    }
}
