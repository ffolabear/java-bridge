package bridge.service;

public enum GameAttribute {

    UP("U"),
    DOWN("D"),
    CROSSABLE("O"),
    UNCROSSABLE("X");

    private final String attribute;

    GameAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
