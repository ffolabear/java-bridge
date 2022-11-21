package bridge.service;

import bridge.util.InputView;
import bridge.util.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Round {

    final List<String> answerBridge;
    final List<String> userBridge;
    private final List<List<String>> resultBridge;
    InputView inputView;

    public Round(List<String> answerBridge, List<String> userBridge) {
        this.answerBridge = answerBridge;
        this.userBridge = userBridge;
        inputView = new InputView();
        resultBridge = new ArrayList<>();
    }

    public void start() {
        makeRoundResult();
        printRoundResult();
    }

    public String inputCommand() {
        String command = inputView.readMoving();
        inputView.validateGameCommand();
        return command;
    }

    /**
     * 라운드 결과 관련
     */
    public void makeRoundResult() {
        for (int index = 0; index < userBridge.size(); index++) {
            List<String> moveResult = makeMoveResult(index);
            resultBridge.add(moveResult);
            if (moveResult.get(1).equals(GameAttribute.UNCROSSABLE.getAttribute())) {
                break;
            }
        }
    }

    /**
     * 라운드 결과 관련
     */
    private List<String> makeMoveResult(int index) {
        List<String> moveResult = new ArrayList<>();
        moveResult.add(userBridge.get(index));
        moveResult.add(judge(index));
        return moveResult;
    }

    /**
     * 라운드 결과 관련
     */
    public String judge(int index) {
        if (userBridge.get(index).equals(answerBridge.get(index))) {
            return GameAttribute.CROSSABLE.getAttribute();
        }
        return GameAttribute.UNCROSSABLE.getAttribute();
    }


    /**
     * ############
     * 라운드 판정 관련
     */
    public boolean continueRound() {
        int lastIndex = userBridge.size() - 1;
        return userBridge.isEmpty() || userBridge.get(lastIndex).equals(answerBridge.get(lastIndex));
    }

    public void printRoundResult() {
        OutputView.printMap(resultBridge);
    }

    public void printFinalResult(long trial, boolean gameResult) {
        OutputView.printResult(resultBridge, gameResult(gameResult), trial);
    }

    /**
     * ############
     * 라운드 판정 관련
     */
    public boolean retryRound() {
        String command = inputView.readGameCommand();
        inputView.validateRetryCommand();
        return command.equals(GameAttribute.RETRY.getAttribute());
    }

    public String gameResult(boolean gameResult) {
        if (gameResult) {
            return GameAttribute.SUCCESS.getAttribute();
        }
        return GameAttribute.FAIL.getAttribute();
    }

    /**
     * ############
     * 라운드 판정 관련
     */
    public boolean isUserBridgeCorrect() {
        return answerBridge.equals(userBridge);
    }


}
