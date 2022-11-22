package bridge.util;

import bridge.validation.Validation;
import bridge.view.Messages;
import camp.nextstep.edu.missionutils.Console;

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

    public void validateEmptyInput(String input) {
        inputValidation.validateEmptyInput(input);
    }

    public String readBridgeSize() {
        OutputView.printSystemMessage(Messages.INPUT_BRIDGE_LENGTH_MESSAGE);
        bridgeLength = Console.readLine();
        return bridgeLength;
    }

    public String readMoving() {
        OutputView.printSystemMessage(Messages.INPUT_GAME_COMMAND_MESSAGE);
        command = Console.readLine();
        return command;
    }

    public String readGameCommand() {
        OutputView.printSystemMessage(Messages.GAME_RETRY_MESSAGE);
        retry = Console.readLine();
        return retry;
    }

    public int convertInput(String input) {
        return Integer.parseInt(input);
    }

}
