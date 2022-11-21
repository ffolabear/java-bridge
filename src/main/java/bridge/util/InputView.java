package bridge.util;

import bridge.validation.Validation;
import bridge.view.Messages;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private String bridgeLength;
    private String command;
    private String retry;
    Validation inputValidation;

    public InputView() {
        inputValidation = new Validation();
    }

    public void validateBridgeLength() {
        inputValidation.validateBridgeLength(bridgeLength);
    }

    public void validateGameCommand() {
        inputValidation.validateGameCommand(command);
    }

    public void validateRetryCommand() {
        inputValidation.validateRetryCommand(retry);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        OutputView.printSystemMessage(Messages.INPUT_BRIDGE_LENGTH_MESSAGE);
        bridgeLength = Console.readLine();
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        OutputView.printSystemMessage(Messages.INPUT_GAME_COMMAND_MESSAGE);
        command = Console.readLine();
        return command;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        OutputView.printSystemMessage(Messages.GAME_RETRY_MESSAGE);
        retry = Console.readLine();
        return retry;
    }

    public int convertInput(String input) {
        return Integer.parseInt(input);
    }

}
