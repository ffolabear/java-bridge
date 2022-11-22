package bridge.service;

import bridge.constant.GameResultConstant;

import java.util.ArrayList;
import java.util.List;

public class RoundResultMaker {

    final Round round;
    final List<String> answerBridge;
    final List<String> userBridge;
    final List<List<String>> resultBridge;

    public RoundResultMaker(Round round) {
        this.round = round;
        this.answerBridge = round.answerBridge;
        this.userBridge = round.userBridge;
        resultBridge = new ArrayList<>();
    }

    public void makeRoundResult() {
        int index;
        for (index = 0; index < userBridge.size(); index++) {
            List<String> moveResult = makeMoveResult(index);
            resultBridge.add(moveResult);
            index = isMoveUncrossable(index, moveResult);
        }
    }

    public int isMoveUncrossable(int index, List<String> moveResult) {
        if (moveResult.get(1).equals(GameResultConstant.UNCROSSABLE.getAttribute())) {
            return userBridge.size();
        }
        return index;
    }

    private List<String> makeMoveResult(int index) {
        List<String> moveResult = new ArrayList<>();
        moveResult.add(userBridge.get(index));
        moveResult.add(validateMove(index));
        return moveResult;
    }

    public String validateMove(int index) {
        if (userBridge.get(index).equals(answerBridge.get(index))) {
            return GameResultConstant.CROSSABLE.getAttribute();
        }
        return GameResultConstant.UNCROSSABLE.getAttribute();
    }

}
