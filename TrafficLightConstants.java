public class TrafficLightConstants {
    
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int YELLOW = 2;
    public static String[] lightNames = {"RED", "GREEN", "YELLOW"};

    public int getNextLight(int light) {
        int nextLight = RED;
        switch (light) {
            case RED:
                nextLight = GREEN;
                break;
            case YELLOW:
                nextLight = RED;
                break;
            case GREEN:
                nextLight = YELLOW;
                break;
            default:
                nextLight = RED;
                break;
        }
        System.out.println("Current light: " + lightNames[light] + " Next light: " + lightNames[nextLight]);
        return nextLight;
    }
}
