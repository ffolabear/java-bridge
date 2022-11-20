package bridge.service;

public enum GameAttribute {

    UP("U"),
    DOWN("D"),
    CROSSABLE("O"),
    UNCROSSABLE("X"),
    RETRY("R"),
    QUIT("Q"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String attribute;

    GameAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
