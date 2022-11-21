package bridge.view;

public enum BridgePiece {

    HEAD("[ "),
    BOARD(" | "),
    TAIL(" ]"),
    EMPTY(" ");

    private final String piece;

    BridgePiece(String piece) {
        this.piece = piece;
    }

    public String getPiece() {
        return piece;
    }
}
