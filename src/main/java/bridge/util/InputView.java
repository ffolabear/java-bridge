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

    public boolean validateBridgeLength() {
        return inputValidation.validateBridgeLength(bridgeLength);
    }

    public boolean validateMoveCommand() {
        return inputValidation.validateMoveCommand(command);
    }

    public boolean validateRetryCommand() {
        return inputValidation.validateRetryCommand(retry);
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
