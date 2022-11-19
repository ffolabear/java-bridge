package bridge.view;

public enum Bridge {

    SUCCESS("O"),
    FAIL("X"),
    HEAD("[ "),
    BOARD(" | "),
    TAIL(" ]"),
    EMPTY(" ");

    private final String piece;

    Bridge(String piece) {
        this.piece = piece;
    }

    public String getPiece() {
        return piece;
    }
}
