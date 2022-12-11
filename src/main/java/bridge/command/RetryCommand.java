package bridge.command;

public enum RetryCommand {

    RETRY("R"),
    QUIT("Q");

    private final String retry;

    RetryCommand(String retry) {
        this.retry = retry;
    }

    public String getRetry() {
        return retry;
    }

}
