package bridge.validation;

import bridge.view.Errors;

public interface Predicate {

//    String test(String input);
    void test(String input);

    void printError(Errors error);

}
