package bridge.service;

import bridge.util.InputView;

import java.util.List;

public class RoundJudge {

    Round round;
    final List<String> answerBridge;
    final List<String> userBridge;
    InputView inputView;

    public RoundJudge(Round round) {
        this.round = round;
        this.answerBridge = round.answerBridge;
        this.userBridge = round.userBridge;
        inputView = new InputView();
    }

    public boolean compareBridgeSize() {
        if (userBridge == null || userBridge.size() < answerBridge.size()) {
            return true;
        }
        return false;
    }

    public boolean continueRound() {
        int lastIndex = userBridge.size() - 1;
        return !userBridge.isEmpty() && !userBridge.get(lastIndex).equals(answerBridge.get(lastIndex));
    }

    public boolean retryRound() {
        String command = inputView.readGameCommand();
        inputView.validateRetryCommand();
        return command.equals(GameAttribute.RETRY.getAttribute());
    }

    public boolean isUserBridgeCorrect() {
        return answerBridge.equals(userBridge);
    }


}
