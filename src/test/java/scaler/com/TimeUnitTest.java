package scaler.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeUnitTest {

    @Test
    public void getPluralDisplayedName_ShouldReturnNotPluralDisplayedName() {
        var timeUnit = TimeUnit.MINUTE;
        var amount = 1;
        var expectedDisplayedName = timeUnit.getDisplayedName();
        Assertions.assertEquals(expectedDisplayedName, timeUnit.getPluralDisplayedName(amount));
    }

    @Test
    public void getPluralDisplayedName_ShouldReturnPluralDisplayedName() {
        var timeUnit = TimeUnit.MINUTE;
        var amount = 2;
        var expectedDisplayedName = timeUnit.getDisplayedName() + "s";
        Assertions.assertEquals(expectedDisplayedName, timeUnit.getPluralDisplayedName(amount));
    }
}
