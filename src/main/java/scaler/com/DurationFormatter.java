package scaler.com;

import java.util.ArrayList;
import java.util.List;

public class DurationFormatter {

    private static final List<TimeUnit> TIME_UNITS = List.of(TimeUnit.YEAR, TimeUnit.DAY, TimeUnit.HOUR, TimeUnit.MINUTE, TimeUnit.SECOND);
    private static final String SEPARATOR = ", ";
    private static final String LAST_SEPARATOR = " and ";

    public String formatSeconds(long seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Seconds cannot be negative.");
        }
        if (seconds == 0) {
            return "now";
        }
        var timeUnitTokens = new ArrayList<String>();
        var remainingSeconds = seconds;
        for (var timeUnit : TIME_UNITS) {
            final var unitAmount = remainingSeconds / timeUnit.getSeconds();
            remainingSeconds = remainingSeconds - unitAmount * timeUnit.getSeconds();
            if (unitAmount > 0) {
                timeUnitTokens.add(unitAmount + " " + timeUnit.getPluralDisplayedName(unitAmount));
            }
        }
        return getFormattedDuration(timeUnitTokens);
    }

    private String getFormattedDuration(List<String> timeUnitTokens) {
        if (timeUnitTokens.size() == 1) {
            return timeUnitTokens.get(0);
        }
        var formattedDurationEnd = String.join(LAST_SEPARATOR, timeUnitTokens.subList(timeUnitTokens.size() - 2, timeUnitTokens.size()));
        if (timeUnitTokens.size() == 2) {
            return formattedDurationEnd;
        }
        return String.join(SEPARATOR, timeUnitTokens.subList(0, timeUnitTokens.size() - 2)) + SEPARATOR + formattedDurationEnd;
    }
}
