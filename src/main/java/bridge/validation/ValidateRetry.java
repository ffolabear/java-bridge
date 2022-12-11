package bridge.validation;

import bridge.command.RetryCommand;
import bridge.view.Errors;

public class ValidateRetry implements Predicate{

//    @Override
//    public String test(String input) {
//        return "";
//    }

    @Override
    public void test(String input) {

    }

    private void isValidRetry(String input) {
        if (!input.equals(RetryCommand.RETRY.getRetry()) && !input.equals(RetryCommand.QUIT.getRetry())) {
            printError(Errors.ERROR_INVALID_MOVE);
        }
    }

    @Override
    public void printError(Errors error) {

    }
}
