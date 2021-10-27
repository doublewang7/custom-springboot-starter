package me.garry.trial;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestJodaTime {
    private Logger logger = Logger.getAnonymousLogger();

    @Test
    void TestDateTime() {
        DateTime dateTime = new DateTime();
        int hourOfDay = dateTime.getHourOfDay();
        logger.log(Level.INFO, "hour of day = {0}", hourOfDay);
        Assertions.assertTrue(hourOfDay >= 0 && hourOfDay < 24);
    }
}
