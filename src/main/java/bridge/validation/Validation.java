package bridge.validation;

import bridge.constant.GameCommand;
import bridge.constant.Bridge;

import static bridge.view.Errors.*;

public class Validation {

    private final String errorHead = ERROR_HEAD.getError();

    public void validateBridgeLength(String input) {
        validateLengthDigit(input);
        validateLengthInteger(input);
        validateLengthRange(Integer.parseInt(input));
    }

    private void validateLengthDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(errorHead + ERROR_NON_DIGIT.getError());
        }
    }

    public void validateEmptyInput(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(errorHead + ERROR_EMPTY_INPUT.getError());
        }
    }

    private void validateLengthRange(int convertedInput) {
        if (convertedInput < Bridge.START_OF_RANGE.getRange() || Bridge.END_OF_RANGE.getRange() < convertedInput) {
            throw new IllegalArgumentException(errorHead + ERROR_INVALID_BRIDGE_LENGTH.getError());
        }
    }

    private void validateLengthInteger(String input) {
        if (Long.parseLong(input) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(errorHead + ERROR_EXCESS_INTEGER.getError());
        }
    }

    public void validateGameCommand(String gameCommandInput) {
        if (!gameCommandInput.equals(GameCommand.UP.getCommand()) &&
                !gameCommandInput.equals(GameCommand.DOWN.getCommand())) {
            throw new IllegalArgumentException(errorHead + ERROR_INVALID_GAME_COMMAND.getError());
        }
    }

    public void validateRetryCommand(String gameCommandInput) {
        if (!gameCommandInput.equals(GameCommand.RETRY.getCommand()) &&
                !gameCommandInput.equals(GameCommand.QUIT.getCommand())) {
            throw new IllegalArgumentException(errorHead + ERROR_INVALID_REPLAY_COMMAND.getError());
        }
    }

    public void validateTrialNumber(long trial) {
        if (trial > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(errorHead + ERROR_EXCESS_MAXIMUM_TRIAL.getError());
        }
    }
}
