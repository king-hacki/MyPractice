package oca_8.different_tests.tests;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TestDateDayToMonthTransition {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 1, 30);
        date = date.plusDays(2);
        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
