package bridge.validation;

import bridge.view.Errors;

public class ValidateBridgeLength implements Predicate {

    @Override
    public void test(String input) {
        try {
            isLengthDigit(input);
            isValidRange(convertToInteger(input));
        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void printError(Errors error) {
        throw new IllegalArgumentException(error.getError());
    }

    private void isLengthDigit(String input) {
        if (!input.matches("[0-9]+")) {
            printError(Errors.ERROR_DIGIT);
        }
    }

    private void isValidRange(int length) {
        if (length < 3 || 20 < length) {
            printError(Errors.ERROR_RANGE);
        }
    }

    public int convertToInteger(String input) {
        return Integer.parseInt(input);
    }
}
