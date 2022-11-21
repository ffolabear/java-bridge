package bridge.service;

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
        moveResult.add(validateMove(index));
        return moveResult;
    }

    public String validateMove(int index) {
        if (userBridge.get(index).equals(answerBridge.get(index))) {
            return GameAttribute.CROSSABLE.getAttribute();
        }
        return GameAttribute.UNCROSSABLE.getAttribute();
    }



}
