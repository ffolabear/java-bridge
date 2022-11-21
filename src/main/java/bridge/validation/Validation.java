package bridge.validation;

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
        if (convertedInput < 3 || 20 < convertedInput) {
            throw new IllegalArgumentException(errorHead + Errors.ERROR_INVALID_BRIDGE_LENGTH.getError());
        }
    }

    public void validateGameCommand(String gameCommandInput) {
        if (!gameCommandInput.equals("U") && !gameCommandInput.equals("D")) {
            throw new IllegalArgumentException(errorHead + Errors.ERROR_INVALID_GAME_COMMAND.getError());
        }
    }

    public void validateRetryCommand(String gameCommandInput) {
        if (!gameCommandInput.equals("R") && !gameCommandInput.equals("Q")) {
            throw new IllegalArgumentException(errorHead + Errors.ERROR_INVALID_REPLAY_COMMAND.getError());
        }
    }

    public void validateTrialNumber(long trial) {
        if (trial > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(errorHead + Errors.ERROR_EXCESS_MAXIMUM_TRIAL.getError());
        }
    }
}
