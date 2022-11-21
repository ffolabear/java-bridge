package bridge.service;

import bridge.constant.GameCommand;
import bridge.util.InputView;

import java.util.List;

public class RoundJudge {

    final List<String> answerBridge;
    final List<String> userBridge;
    Round round;
    InputView inputView;

    public RoundJudge(Round round) {
        this.round = round;
        this.answerBridge = round.answerBridge;
        this.userBridge = round.userBridge;
        inputView = new InputView();
    }

    public boolean judgeCompareBridgeSize() {
        return userBridge == null || userBridge.size() < answerBridge.size();
    }

    public boolean judgeContinueRound() {
        int lastIndex = userBridge.size() - 1;
        return !userBridge.isEmpty() && !userBridge.get(lastIndex).equals(answerBridge.get(lastIndex));
    }

    public boolean judgeRetryRound() {
        String command = inputView.readGameCommand();
        inputView.validateRetryCommand();
        return command.equals(GameCommand.RETRY.getCommand());
    }

    public boolean isUserBridgeCorrect() {
        return answerBridge.equals(userBridge);
    }


}
