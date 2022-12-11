package bridge.validation;

import bridge.command.MoveCommand;
import bridge.view.Errors;

public class ValidateMove implements Predicate{

//    @Override
//    public String test(String input) {
//        return "";
//    }

    @Override
    public void test(String input) {

    }

    private void isValidMove(String input) {
        if (!input.equals(MoveCommand.UP.getMove()) && !input.equals(MoveCommand.DOWN.getMove())) {
            printError(Errors.ERROR_INVALID_MOVE);
        }
    }

    @Override
    public void printError(Errors error) {

    }
}
