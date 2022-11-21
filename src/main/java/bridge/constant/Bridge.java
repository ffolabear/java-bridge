package bridge.constant;

public enum Bridge {

    START_OF_RANGE(3),
    END_OF_RANGE(20);

    private final int range;

    Bridge(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
