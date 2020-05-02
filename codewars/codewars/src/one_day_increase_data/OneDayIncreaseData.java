package one_day_increase_data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class OneDayIncreaseData {

    public static void main(String[] args) {

        //  1 day
        Long dayIncrease = 1000L * 60 * 60 * 24;

        //  for normal format
        DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");

        //  list of dates
        List<Date> dates = new ArrayList<>(Arrays.asList(new Date(), new Date(), new Date(), new Date()));

        dates.forEach(date -> System.out.println("Now : " + df.format(date)));
        dates = increaseOn(dates, dayIncrease);
        dates.forEach(date -> System.out.println("One day increase : " + df.format(date)));
    }

    public static List<Date> increaseOn ( List<Date> dates, Long dayIncrease) {

        List<Date> increasedDates = new ArrayList<>();

        dates.forEach(date -> increasedDates.add(new Date(date.getTime() + dayIncrease)));

        return increasedDates;
    }
}
