package bridge.service;

public enum GameResult {

    CROSSABLE("O"),
    UNCROSSABLE("X"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String attribute;

    GameResult(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
