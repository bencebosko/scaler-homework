package scaler.com;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TimeUnit {
    YEAR("year", TimeUnitConstants.SECONDS_OF_A_YEAR),
    DAY("day", TimeUnitConstants.SECONDS_OF_A_DAY),
    HOUR("hour", TimeUnitConstants.SECONDS_OF_AN_HOUR),
    MINUTE("minute", TimeUnitConstants.SECONDS_OF_A_MINUTE),
    SECOND("second", 1);

    private final String displayedName;
    private final int seconds;

    public String getPluralDisplayedName(long amount) {
        return displayedName + (amount > 1 ? "s": "");
    }
}
