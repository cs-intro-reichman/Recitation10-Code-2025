public class TrafficLightDecision {
    
    public CarActionEnum decide(TrafficLightEnum light) {
        CarActionEnum action = CarActionEnum.STOP;
        switch (light) {
            case RED:
                action = CarActionEnum.STOP;
                break;
            case YELLOW:
                action = CarActionEnum.SLOW_DOWN;
                break;
            case GREEN:
                action = CarActionEnum.GO;
                break;
            default:
                action = CarActionEnum.STOP;
                break;
        }
        return action;
    }

    public static void iterateEnum() {
        TrafficLightEnum[] lights = TrafficLightEnum.values();
        for (int i = 0; i < lights.length; i++) {
            System.out.println(lights[i]);
        }
    }
}
