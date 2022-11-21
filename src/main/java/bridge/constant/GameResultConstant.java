package bridge.constant;

public enum GameResultConstant {

    CROSSABLE("O"),
    UNCROSSABLE("X"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String attribute;

    GameResultConstant(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
