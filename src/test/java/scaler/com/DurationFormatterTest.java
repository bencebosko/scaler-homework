package scaler.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static scaler.com.TimeUnitConstants.SECONDS_OF_AN_HOUR;
import static scaler.com.TimeUnitConstants.SECONDS_OF_A_DAY;
import static scaler.com.TimeUnitConstants.SECONDS_OF_A_MINUTE;
import static scaler.com.TimeUnitConstants.SECONDS_OF_A_YEAR;

public class DurationFormatterTest {

    private final DurationFormatter durationFormatter = new DurationFormatter();

    @Test
    public void formatSeconds_shouldThrowExceptionForNegativeSeconds() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> durationFormatter.formatSeconds(-1), "Seconds cannot be negative.");
    }


    @Test
    public void formatSeconds_shouldReturnNowForZeroSeconds() {
        Assertions.assertEquals("now", durationFormatter.formatSeconds(0));
    }

    @Test
    public void formatSeconds_shouldFormatYearsCorrectly() {
        long years = 2;
        long totalSeconds = years * SECONDS_OF_A_YEAR;
        var expectedFormat = years + " years";
        Assertions.assertEquals(expectedFormat, durationFormatter.formatSeconds(totalSeconds));
    }

    @Test
    public void formatSeconds_shouldFormatDaysCorrectly() {
        long days = 2;
        long totalSeconds = days * SECONDS_OF_A_DAY;
        var expectedFormat = days + " days";
        Assertions.assertEquals(expectedFormat, durationFormatter.formatSeconds(totalSeconds));
    }

    @Test
    public void formatSeconds_shouldFormatHoursCorrectly() {
        long hours = 2;
        long totalSeconds = hours * SECONDS_OF_AN_HOUR;
        var expectedFormat = hours + " hours";
        Assertions.assertEquals(expectedFormat, durationFormatter.formatSeconds(totalSeconds));
    }

    @Test
    public void formatSeconds_shouldFormatMinutesCorrectly() {
        long minutes = 2;
        long totalSeconds = minutes * SECONDS_OF_A_MINUTE;
        var expectedFormat = minutes + " minutes";
        Assertions.assertEquals(expectedFormat, durationFormatter.formatSeconds(totalSeconds));
    }

    @Test
    public void formatSeconds_shouldFormatSecondsCorrectly() {
        long seconds = 2;
        var expectedFormat = seconds + " seconds";
        Assertions.assertEquals(expectedFormat, durationFormatter.formatSeconds(seconds));
    }

    @Test
    public void formatSeconds_shouldNotAddDaysAndMinutes() {
        long years = 2;
        long hours = 2;
        long seconds = 2;
        long totalSeconds = years * SECONDS_OF_A_YEAR + hours * SECONDS_OF_AN_HOUR + seconds;
        var expectedFormat = years + " years, " + hours + " hours and " + seconds + " seconds";
        Assertions.assertEquals(expectedFormat, durationFormatter.formatSeconds(totalSeconds));
    }

    @Test
    public void formatSeconds_shouldFormatCorrectly2Units() {
        long years = 999;
        long seconds = 59;
        long totalSeconds = years * SECONDS_OF_A_YEAR + seconds;
        var expectedFormat = years + " years and " + seconds + " seconds";
        Assertions.assertEquals(expectedFormat, durationFormatter.formatSeconds(totalSeconds));
    }

    @Test
    public void formatSeconds_shouldFormatCorrectly5Units() {
        long years = 999;
        long days = 364;
        long hours = 23;
        long minutes = 59;
        long seconds = 59;
        long totalSeconds = years * SECONDS_OF_A_YEAR + SECONDS_OF_A_DAY * days + SECONDS_OF_AN_HOUR * hours + SECONDS_OF_A_MINUTE * minutes + seconds;
        var expectedFormat = years + " years, " + days + " days, " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds";
        Assertions.assertEquals(expectedFormat, durationFormatter.formatSeconds(totalSeconds));
    }
}
