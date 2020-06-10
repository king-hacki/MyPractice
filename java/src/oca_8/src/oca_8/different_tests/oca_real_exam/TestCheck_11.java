package oca_8.different_tests.oca_real_exam;

public class TestCheck_11 {
    public static void main(String[] args) {
        String race = "";
        do {
            do {
                race += "x";
            } while (race.length() <= 4);
        } while (race.length() < 4);
        System.out.println(race);
    }
}
