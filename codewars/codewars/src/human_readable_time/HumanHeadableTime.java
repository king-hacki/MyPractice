package human_readable_time;

public class HumanHeadableTime {

    public static void main(String[] args) {
        System.out.println(humanTime(10_000));
    }

    public static String humanTime(int g) {

        int h = g / 3600;
        int m = (g - 3600 * h) / 60;
        int s = ((g - h * 3600) - m * 60);

        return String.format("%02d:%02d:%02d", h, m, s);

    }

    public static String someBetter(int g) {
        return String.format("%02d:%02d:%02d", g / 3600, (g / 60) % 60, g % 60);
    }

}


