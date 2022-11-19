package bridge.service;

public enum GameAttribute {

    UP("U"),
    DOWN("D"),
    CROSSABLE("O"),
    EMPTY(" "),
    UNCROSSABLE("X"),
    RETRY("R"),
    QUIT("Q");

    private final String attribute;

    GameAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
