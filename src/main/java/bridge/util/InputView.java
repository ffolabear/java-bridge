package bridge.util;

import bridge.validation.ValidateBridgeLength;
import bridge.validation.ValidateMove;
import bridge.validation.ValidateRetry;
import bridge.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printMessage(SystemMessage.START_MESSAGE);
        String length = Console.readLine();
        ValidateBridgeLength validate = new ValidateBridgeLength();
        validate.test(length);
        return validate.convertToInteger(length);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMessage(SystemMessage.INPUT_MOVE_MESSAGE);
        String move = Console.readLine();
        ValidateMove validateMove = new ValidateMove();
        validateMove.test(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printMessage(SystemMessage.INPUT_RETRY_MESSAGE);
        String retry = Console.readLine();
        ValidateRetry validateRetry = new ValidateRetry();
        validateRetry.test(retry);
        return retry;
    }
}
