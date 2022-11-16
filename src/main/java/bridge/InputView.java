package bridge;

import bridge.view.Errors;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        String lengthInput = Console.readLine();
        return lengthInput;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }



    private int convertInput(String input) {
        return Integer.parseInt(input);
    }

    /*
        입력값 검증부
     */
    private void isLengthDigit(String lengthInput) {
        if (!lengthInput.matches("[0-9]+")){
            throw new IllegalArgumentException(Errors.ERROR_NON_DIGIT.getError());
        }
    }

    private void isLengthValidRange(int convertedInput) {
        if (convertedInput < 3  || 20 < convertedInput){
            throw new IllegalArgumentException(Errors.ERROR_INVALID_BRIDGE_LENGTH.getError());
        }
    }

    private void isValidGameCommand(String gameCommandInput) {
        if (!gameCommandInput.equals("U") && !gameCommandInput.equals("D")) {
            throw new IllegalArgumentException(Errors.ERROR_INVALID_GAME_COMMAND.getError());
        }
    }

    private void isValidReplayCommand(String gameCommandInput) {
        if (!gameCommandInput.equals("R") && !gameCommandInput.equals("Q")) {
            throw new IllegalArgumentException(Errors.ERROR_INVALID_REPLAY_COMMAND.getError());
        }
    }



}
