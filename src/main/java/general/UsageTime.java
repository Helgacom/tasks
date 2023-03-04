package general;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class UsageTime {
    public static void main(String[] args) {
        /* static method now() show current data, time or data/time
        2022-12-07
        11:16:35.028139
        2022-12-07T11:16:35.028329*/
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        /*creating objects
        2016-01-01
        2016-12-01
        08:23
        08:23:15
        2016-01-01T12:30:45*/
        LocalDate date = LocalDate.of(2016, 1, 1);
        System.out.println(date);

        LocalDate date1 = LocalDate.of(2016, Month.DECEMBER, 1);
        System.out.println(date1);

        LocalTime time = LocalTime.of(8, 23);
        System.out.println(time);

        LocalTime time1 = LocalTime.of(8, 23, 15);
        System.out.println(time1);

        LocalDateTime dateTime = LocalDateTime.of(2016, 1, 1, 12, 30, 45);
        System.out.println(dateTime);

        /*examples methods*/
        date = date.plusDays(1);
        System.out.println(date); //2016-01-02
        date = date.plusMonths(1); //2016-02-02
        date = date.minusDays(1);
        System.out.println(date);

        /*ZonedDateTime*/
        System.out.println(ZonedDateTime.now()); //2022-12-07T12:04:48.681630+04:00[Europe/Saratov]
        LocalDate date2 = LocalDate.of(2017, 12, 30);
        LocalTime time2 = LocalTime.of(12, 30);
        ZoneId zone = ZoneId.of("Europe/Moscow");
        ZonedDateTime zoned = ZonedDateTime.of(date2, time2, zone);
        System.out.println(zoned); //2016-02-01T08:23+03:00[Europe/Moscow]

        /*periods*/
        Period period1 = Period.ofMonths(2); //way 1

        LocalDate dateStart = LocalDate.of(2016, Month.SEPTEMBER, 1);
        LocalDate dateEnd = LocalDate.of(2016, Month.OCTOBER, 15);
        Period period2 = Period.between(dateStart, dateEnd); //way 2

        /*durations (work with time)*/
        Duration minute = Duration.ofMinutes(30); // PT30M
        System.out.println(minute);

        Duration halfDay = Duration.of(1, ChronoUnit.HALF_DAYS);
        //ChronoUnit - class for creating other durations
        System.out.println(halfDay); //PT12H

        /*instants*/
        Instant now = Instant.now();
        System.out.println(now);

        /*formatter*/

        LocalDate date3 = LocalDate.of(2022, Month.JULY, 27);
        LocalTime time3 = LocalTime.of(14, 20);
        LocalDateTime dateTime1 = LocalDateTime.of(date3, time3);
        DateTimeFormatter shortDataTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDataTime.format(dateTime1)); //27.07.2022

        /*own formatter*/
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd MMMM yyyy, hh mm");
        System.out.println(dateTime1.format(formatter1)); //27 июля 2022, 02 20

    }
}
