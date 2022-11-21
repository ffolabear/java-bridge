package bridge.util;

import bridge.service.GameAttribute;
import bridge.view.Bridge;

import java.util.List;

public class BridgeFormat {

    private final StringBuilder upperBridge;
    private final StringBuilder lowerBridge;
    private final List<List<String>> resultBridge;

    public BridgeFormat(List<List<String>> resultBridge) {
        this.resultBridge = resultBridge;
        upperBridge = new StringBuilder();
        lowerBridge = new StringBuilder();
        createBridgeMap();
    }

    public String formattedBridge() {
        return upperBridge.append("\n").append(lowerBridge).toString();
    }

    private void createBridgeMap() {
        addPiece(Bridge.HEAD.getPiece());
        for (int index = 0; index < resultBridge.size(); index++) {
            addPiece(addBody(index));
            List<String> round = resultBridge.get(index);
            setLevel(round).append(round.get(1));
        }
        addPiece(Bridge.TAIL.getPiece());
    }

    private StringBuilder setLevel(List<String> round) {
        if (round.get(0).equals(GameAttribute.UP.getAttribute())) {
            lowerBridge.append(" ");
            return upperBridge;
        }
        upperBridge.append(" ");
        return lowerBridge;
    }

    private String addBody(int index) {
        if (index == 0 || resultBridge.size() <= 1) {
            return "";
        }
        return Bridge.BOARD.getPiece();
    }

    private void addPiece(String piece) {
        upperBridge.append(piece);
        lowerBridge.append(piece);
    }

}
