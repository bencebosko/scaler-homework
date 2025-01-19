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
        var durationTokens = new ArrayList<String>();
        var remainingSeconds = seconds;
        for (var timeUnit : TIME_UNITS) {
            final var amount = remainingSeconds / timeUnit.getSeconds();
            remainingSeconds = remainingSeconds - amount * timeUnit.getSeconds();
            if (amount > 0) {
                durationTokens.add(amount + " " + timeUnit.getPluralDisplayedName(amount));
            }
        }
        return getFormattedDuration(durationTokens);
    }

    private String getFormattedDuration(List<String> durationTokens) {
        if (durationTokens.size() == 1) {
            return durationTokens.get(0);
        }
        var formattedDurationEnd = String.join(LAST_SEPARATOR, durationTokens.subList(durationTokens.size() - 2, durationTokens.size()));
        if (durationTokens.size() == 2) {
            return formattedDurationEnd;
        }
        return String.join(SEPARATOR, durationTokens.subList(0, durationTokens.size() - 2)) + SEPARATOR + formattedDurationEnd;
    }
}
