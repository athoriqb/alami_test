package utils;

import java.util.Map;

public class DateUtils {

    // Month mapping
    private static final Map<String, Integer> monthOrder = Map.ofEntries(
            Map.entry("January", 1),
            Map.entry("February", 2),
            Map.entry("March", 3),
            Map.entry("April", 4),
            Map.entry("May", 5),
            Map.entry("June", 6),
            Map.entry("July", 7),
            Map.entry("August", 8),
            Map.entry("September", 9),
            Map.entry("October", 10),
            Map.entry("November", 11),
            Map.entry("December", 12)
    );

    // Method to get the month order
    public static Integer getMonthOrder(String month) {
        return monthOrder.get(month);
    }

    // Method to get month order as two-digit string (e.g., "01" for January)
    public static String getMonthNumber(String month) {
        Integer monthOrder = getMonthOrder(month);
        return monthOrder != null ? String.format("%02d", monthOrder) : null;
    }
}
