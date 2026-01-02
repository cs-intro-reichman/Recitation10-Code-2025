public class TrafficLight {
    
    public TrafficLightEnum getNextLight(TrafficLightEnum light) {
        TrafficLightEnum nextLight = TrafficLightEnum.RED;
        switch (light) {
            case RED:
                nextLight = TrafficLightEnum.YELLOW;
                break;
            case YELLOW:
                nextLight = TrafficLightEnum.GREEN;
                break;
            case GREEN:
                nextLight = TrafficLightEnum.RED;
                break;
            default:
                nextLight = TrafficLightEnum.RED;
                break;
        }
        System.out.println("Current light: " + light + " Next light: " + nextLight);
        return nextLight;
    }
}
