package bridge.view;

public enum Bridge {

    HEAD("[ "),
    BOARD(" | "),
    TAIL(" ]");

    private final String piece;

    Bridge(String piece) {
        this.piece = piece;
    }

    public String getPiece() {
        return piece;
    }
}
