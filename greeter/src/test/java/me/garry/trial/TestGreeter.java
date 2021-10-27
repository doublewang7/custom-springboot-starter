package me.garry.trial;

import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestGreeter {
    private static Logger logger = Logger.getAnonymousLogger();

    @Test
    void testGreet() {
        Greeter greeter = new Greeter("xyz");
        String greeting = greeter.greet();
        logger.log(Level.INFO, "{0}", greeting);
    }
}
