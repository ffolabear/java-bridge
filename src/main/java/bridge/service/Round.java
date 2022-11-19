package bridge.service;

import bridge.util.InputView;
import bridge.validation.InputValidation;
import bridge.util.OutputView;
import bridge.view.Messages;

import java.util.ArrayList;
import java.util.List;

public class Round {

    final List<String> answerBridge;
    final List<String> userBridge;
    List<List<String>> resultBridge;
    InputView inputView;
    OutputView outputView;
    InputValidation validator;

    public Round(List<String> answerBridge, List<String> userBridge) {
        this.answerBridge = answerBridge;
        this.userBridge = userBridge;
        inputView = new InputView();
        outputView = new OutputView();
        validator = new InputValidation();
        resultBridge = new ArrayList<>();
    }

    public void start() {
        makeRoundResult();
        printRoundResult();
    }

    public String inputCommand() {
        String command = inputView.readMoving();
        validator.validateGameCommand(command);
        return command;
    }

    public void makeRoundResult() {
        for (int index = 0; index < userBridge.size(); index++) {
            List<String> moveResult = makeMoveResult(index);
            resultBridge.add(moveResult);
            if (moveResult.get(1).equals(GameAttribute.UNCROSSABLE.getAttribute())) {
                break;
            }
        }
    }

    private List<String> makeMoveResult(int index) {
        List<String> moveResult = new ArrayList<>();
        moveResult.add(userBridge.get(index));
        moveResult.add(judge(index));
        return moveResult;
    }

    public String judge(int index) {
        if (userBridge.get(index).equals(answerBridge.get(index))) {
            return GameAttribute.CROSSABLE.getAttribute();
        }
        return GameAttribute.UNCROSSABLE.getAttribute();
    }

    public boolean continueRound() {
        int lastIndex = userBridge.size() - 1;
        if (!userBridge.isEmpty() && !userBridge.get(lastIndex).equals(answerBridge.get(lastIndex))) {
            return false;
        }
        return true;
    }

    public void printRoundResult() {
        outputView.printMap(resultBridge);
    }

    public void printFinalResult() {
        outputView.printResult(resultBridge);
    }

    public String retryRound() {
        outputView.printSystemMessage(Messages.GAME_RETRY_MESSAGE);
        String command = inputView.readGameCommand();
        if (command.equals(GameAttribute.QUIT.getAttribute())) {

        }
        return inputView.readGameCommand();
    }

}
