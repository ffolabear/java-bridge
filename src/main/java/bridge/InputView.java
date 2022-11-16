package bridge;

import bridge.view.Errors;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     * 검증메서드 : isLengthDigit -> convertInput -> isLengthValidRange
     */
    public String readBridgeSize() {
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     * 검증메서드 : isValidGameCommand
     */
    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     * 검증메서드 : isValidReplayCommand
     */
    public String readGameCommand() {
        return Console.readLine();
    }


    /*
        추가 구현 코드
     */

    public int convertInput(String input) {
        return Integer.parseInt(input);
    }

    /*
        입력값 검증부
     */
    public void isLengthDigit(String lengthInput) {
        if (!lengthInput.matches("[0-9]+")) {
            throw new IllegalArgumentException(Errors.ERROR_NON_DIGIT.getError());
        }
    }

    public void isLengthValidRange(int convertedInput) {
        if (convertedInput < 3 || 20 < convertedInput) {
            throw new IllegalArgumentException(Errors.ERROR_INVALID_BRIDGE_LENGTH.getError());
        }
    }

    public void isValidGameCommand(String gameCommandInput) {
        if (!gameCommandInput.equals("U") && !gameCommandInput.equals("D")) {
            throw new IllegalArgumentException(Errors.ERROR_INVALID_GAME_COMMAND.getError());
        }
    }

    public void isValidReplayCommand(String gameCommandInput) {
        if (!gameCommandInput.equals("R") && !gameCommandInput.equals("Q")) {
            throw new IllegalArgumentException(Errors.ERROR_INVALID_REPLAY_COMMAND.getError());
        }
    }


}
