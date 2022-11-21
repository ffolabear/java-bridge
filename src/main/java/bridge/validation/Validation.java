package bridge.validation;

import bridge.constant.GameCommand;
import bridge.constant.Bridge;
import bridge.view.Errors;

public class Validation {

    private final String errorHead = Errors.ERROR_HEAD.getError();

    public void validateBridgeLength(String input) {
        validateLengthDigit(input);
        validateLengthRange(Integer.parseInt(input));
    }

    private void validateLengthDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(errorHead + Errors.ERROR_NON_DIGIT.getError());
        }
    }

    private void validateLengthRange(int convertedInput) {
        if (convertedInput < Bridge.START_OF_RANGE.getRange() || Bridge.END_OF_RANGE.getRange() < convertedInput) {
            throw new IllegalArgumentException(errorHead + Errors.ERROR_INVALID_BRIDGE_LENGTH.getError());
        }
    }

    public void validateGameCommand(String gameCommandInput) {
        if (!gameCommandInput.equals(GameCommand.UP.getCommand()) &&
                !gameCommandInput.equals(GameCommand.DOWN.getCommand())) {
            throw new IllegalArgumentException(errorHead + Errors.ERROR_INVALID_GAME_COMMAND.getError());
        }
    }

    public void validateRetryCommand(String gameCommandInput) {
        if (!gameCommandInput.equals(GameCommand.RETRY.getCommand()) &&
                !gameCommandInput.equals(GameCommand.QUIT.getCommand())) {
            throw new IllegalArgumentException(errorHead + Errors.ERROR_INVALID_REPLAY_COMMAND.getError());
        }
    }

    public void validateTrialNumber(long trial) {
        if (trial > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(errorHead + Errors.ERROR_EXCESS_MAXIMUM_TRIAL.getError());
        }
    }
}
