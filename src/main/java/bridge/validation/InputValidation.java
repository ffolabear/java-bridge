package bridge.validation;

import bridge.view.Errors;

public class InputValidation {

    public void validateBridgeLength(String input) {
        isLengthDigit(input);
        isLengthValidRange(Integer.parseInt(input));
    }

    public void validateGameCommand(String input) {
        isValidGameCommand(input);
    }

    public void validateRetryCommand(String input) {
        isValidReplayCommand(input);
    }

    public void isLengthDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(Errors.ERROR_HEAD.getError() + Errors.ERROR_NON_DIGIT.getError());
        }
    }

    public void isLengthValidRange(int convertedInput) {
        if (convertedInput < 3 || 20 < convertedInput) {
            throw new IllegalArgumentException(Errors.ERROR_HEAD.getError() + Errors.ERROR_INVALID_BRIDGE_LENGTH.getError());
        }
    }

    public void isValidGameCommand(String gameCommandInput) {
        if (!gameCommandInput.equals("U") && !gameCommandInput.equals("D")) {
            throw new IllegalArgumentException(Errors.ERROR_HEAD.getError() + Errors.ERROR_INVALID_GAME_COMMAND.getError());
        }
    }

    public void isValidReplayCommand(String gameCommandInput) {
        if (!gameCommandInput.equals("R") && !gameCommandInput.equals("Q")) {
            throw new IllegalArgumentException(Errors.ERROR_HEAD.getError() + Errors.ERROR_INVALID_REPLAY_COMMAND.getError());
        }
    }


}
