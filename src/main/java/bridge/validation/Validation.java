package bridge.validation;

import bridge.constant.GameCommand;
import bridge.constant.Bridge;

import static bridge.view.Errors.*;

public class Validation {

    private final String errorHead = ERROR_HEAD.getError();

    public boolean validateBridgeLength(String input) {
        return validateLengthDigit(input) && isValidLengthType(input)
                && isValidLengthRange(Integer.parseInt(input)) && isInputEmpty(input);
    }

    public boolean validateMoveCommand(String input) {
        return isValidMoveCommand(input) && isInputEmpty(input);
    }

    public boolean validateRetryCommand(String input) {
        if (isValidRetryCommand(input) && isInputEmpty(input)) {
            return true;
        }
        return false;
    }

    private boolean validateLengthDigit(String input) {
        if (!input.matches("[0-9]+")) {
            System.out.println(errorHead + ERROR_NON_DIGIT.getError());
            return false;
        }
        return true;
    }

    public boolean isInputEmpty(String input) {
        if (input.equals("")) {
            System.out.println(errorHead + ERROR_EMPTY_INPUT.getError());
            return false;
        }
        return true;
    }

    private boolean isValidLengthRange(int convertedInput) {
        if (convertedInput < Bridge.START_OF_RANGE.getRange() || Bridge.END_OF_RANGE.getRange() < convertedInput) {
            System.out.println(errorHead + ERROR_INVALID_BRIDGE_LENGTH.getError());
            return false;
        }
        return true;
    }

    private boolean isValidLengthType(String input) {
        if (Long.parseLong(input) > Integer.MAX_VALUE) {
            System.out.println(errorHead + ERROR_EXCESS_INTEGER.getError());
            return false;
        }
        return true;
    }

    public boolean isValidMoveCommand(String gameCommandInput) {
        if (!gameCommandInput.equals(GameCommand.UP.getCommand()) &&
                !gameCommandInput.equals(GameCommand.DOWN.getCommand())) {
            System.out.println(errorHead + ERROR_INVALID_GAME_COMMAND.getError());
            return false;
        }
        return true;
    }

    public boolean isValidRetryCommand(String gameCommandInput) {
        if (!gameCommandInput.equals(GameCommand.RETRY.getCommand()) &&
                !gameCommandInput.equals(GameCommand.QUIT.getCommand())) {
            System.out.println(errorHead + ERROR_INVALID_REPLAY_COMMAND.getError());
            return false;
        }
        return true;
    }

}
