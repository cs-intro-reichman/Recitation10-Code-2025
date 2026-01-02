public enum TrafficLightEnum {
    RED("RED"),
    YELLOW("YELLOW"),
    GREEN("GREEN");

    private final String light;

    TrafficLightEnum(String light) {
        this.light = light;
    }

    public String getLight() {
        return this.light;
    }
}
