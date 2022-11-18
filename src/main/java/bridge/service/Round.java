package bridge.service;

import bridge.util.InputView;
import bridge.validation.InputValidation;
import bridge.util.OutputView;

import java.util.List;

public class Round {

    List<String> answerBridge;
    List<String> userBridge;
    InputView inputView;
    OutputView outputView;
    InputValidation validator;
    String command;
    int currentRound;

    public Round(List<String> answerBridge, List<String> userBridge, int currentRound) {
        this.answerBridge = answerBridge;
        this.userBridge = userBridge;
        this.currentRound = currentRound;
        inputView = new InputView();
        outputView = new OutputView();
        validator = new InputValidation();
    }

    public void startRound() {
        String input = inputView.readGameCommand();
        validator.isValidGameCommand(command);
        command = input;
    }

    public boolean judge() {
        return answerBridge.get(currentRound).equals(command);
    }

    public void printRoundResult() {

    }

}
