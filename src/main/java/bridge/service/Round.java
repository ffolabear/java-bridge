package bridge.service;

import bridge.constant.GameResultConstant;
import bridge.util.InputView;
import bridge.util.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Round {

    final List<String> answerBridge;
    final List<String> userBridge;
    private List<List<String>> roundResult;
    RoundJudge roundJudge;
    InputView inputView;

    public Round(List<String> answerBridge) {
        this.answerBridge = answerBridge;
        userBridge = new ArrayList<>();
        inputView = new InputView();
        roundJudge = new RoundJudge(Round.this);
    }

    public String inputCommand() {
        String command = inputView.readMoving();
        inputView.validateEmptyInput(command);
        inputView.validateGameCommand();
        return command;
    }

    public boolean compareBridgeSize() {
        return roundJudge.judgeCompareBridgeSize();
    }

    public boolean continueRound() {
        return roundJudge.judgeContinueRound();
    }

    public void makeRoundResult() {
        RoundResultMaker roundResultMaker = new RoundResultMaker(Round.this);
        roundResultMaker.makeRoundResult();
        roundResult = roundResultMaker.resultBridge;
    }

    public void printRoundResult() {
        makeRoundResult();
        OutputView.printMap(roundResult);
    }

    public void printFinalResult(long trial) {
        String result = gameResult(roundJudge.isUserBridgeCorrect());
        OutputView.printResult(roundResult, result, trial);
    }

    public String gameResult(boolean gameResult) {
        if (gameResult) {
            return GameResultConstant.SUCCESS.getAttribute();
        }
        return GameResultConstant.FAIL.getAttribute();
    }

    public boolean retryRound() {
        return roundJudge.judgeRetryRound();
    }
}
