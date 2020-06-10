package oca_8.strings_arrays_arrayList_calendar_lambda;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class CalendarExample {

    private static final String birthday = "04061999";

    public static void main(String[] args) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate birthday = null;

        try {
            birthday = LocalDate.parse(CalendarExample.birthday, dateTimeFormatter);
        } catch (DateTimeException dateTimeException) {
            System.out.println("bad dates");
            System.exit(0);
        }

        System.out.println("your birthday is: " + birthday);
        System.out.println("a " + birthday.getDayOfWeek());

        Period period = Period.between(birthday, LocalDate.now());

        System.out.println("you have lived for : ");
        System.out.print(period.getDays() + " days, ");
        System.out.print(period.getMonths() + " months, ");
        System.out.print(period.getYears() + " years, ");

        int yearsOld = period.getYears();
        if (yearsOld < 0 || yearsOld > 119)
            System.out.println("Wow, you are a time lord");

        long tDays = birthday.until(LocalDate.now(), ChronoUnit.DAYS);

        System.out.println("you have lived for " + tDays + " days, so far");
        System.out.println("you will reach 30,000 days on " + birthday.plusDays(30_000));

        LocalDate d2000 = LocalDate.of(2_000, 1, 1);
        Period period1 = Period.between(d2000, LocalDate.now());

        System.out.println("period since Y2K: " + period1);


    }
}
