package dk.kea;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// opgave 6
public class WednesdayDatesOpg6 {
    public static List<LocalDate> getWeekdayDates(int year, Predicate<LocalDate> weekdayFilter) {
        LocalDate startDate = LocalDate.of(year, 5, 1);
        LocalDate endDate = LocalDate.of(year, 10, 1);

        List<LocalDate> dates = startDate.datesUntil(endDate)
                .filter(weekdayFilter)
                .collect(Collectors.toList());
        return dates;
    }

    public static void main(String[] args) {
        int year = 2024;

        Predicate<LocalDate> isWednesday = date -> date.getDayOfWeek() == DayOfWeek.WEDNESDAY;

        List<LocalDate> wednesdayDates = getWeekdayDates(year, isWednesday);

        wednesdayDates.forEach(System.out::println);
    }
}



