package bridge.service;

import bridge.constant.GameCommand;
import bridge.constant.BridgePiece;

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
        addPiece(BridgePiece.HEAD.getPiece());
        for (int index = 0; index < resultBridge.size(); index++) {
            addPiece(addBody(index));
            List<String> round = resultBridge.get(index);
            setLevel(round).append(round.get(1));
        }
        addPiece(BridgePiece.TAIL.getPiece());
    }

    private StringBuilder setLevel(List<String> round) {
        if (round.get(0).equals(GameCommand.UP.getCommand())) {
            lowerBridge.append(BridgePiece.EMPTY.getPiece());
            return upperBridge;
        }
        upperBridge.append(BridgePiece.EMPTY.getPiece());
        return lowerBridge;
    }

    private String addBody(int index) {
        if (index == 0 || resultBridge.size() <= 1) {
            return "";
        }
        return BridgePiece.BOARD.getPiece();
    }

    private void addPiece(String piece) {
        upperBridge.append(piece);
        lowerBridge.append(piece);
    }

}
