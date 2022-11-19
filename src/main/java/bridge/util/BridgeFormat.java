package bridge.util;

import bridge.service.GameAttribute;
import bridge.view.Bridge;

import java.util.List;

public class BridgeFormat {

    StringBuilder upperBridge;
    StringBuilder lowerBridge;
    private final List<List<String>> resultBridge;

    public BridgeFormat(List<List<String>> resultBridge) {
        this.resultBridge = resultBridge;
        upperBridge = new StringBuilder();
        lowerBridge = new StringBuilder();
        createBridgeMap();
    }

    public String formattedBridge() {
        return upperBridge.append("\n").append(lowerBridge).append("\n").toString();
    }

    private void createBridgeMap() {
        addHead();
        for (int index = 0; index < resultBridge.size(); index++) {
            upperBridge.append(addBody(index));
            lowerBridge.append(addBody(index));
            List<String> round = resultBridge.get(index);
            setLevel(round).append(round.get(1));
        }
        addTail();
    }

    private StringBuilder setLevel(List<String> round) {
        if (round.get(0).equals(GameAttribute.UP.getAttribute())) {
            lowerBridge.append(" ");
            return upperBridge;
        }
        upperBridge.append(" ");
        return lowerBridge;
    }

    private void addHead() {
        upperBridge.append(Bridge.HEAD.getPiece());
        lowerBridge.append(Bridge.HEAD.getPiece());
    }

    private String addBody(int index) {
        if (index == 0 || resultBridge.size() <= 1) {
            return "";
        }
        return Bridge.BOARD.getPiece();
    }

    private void addTail() {
        upperBridge.append(Bridge.TAIL.getPiece());
        lowerBridge.append(Bridge.TAIL.getPiece());
    }


}
