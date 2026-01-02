public enum CarActionEnum {
    SLOW_DOWN("Slow Down"),
    STOP("Stop"),
    GO("Go");

    private final String message;

    CarActionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
