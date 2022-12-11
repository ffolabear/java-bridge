package bridge.command;

public enum MoveCommand {

    UP("U"),
    DOWN("D");

    private final String move;

    MoveCommand(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }
}
