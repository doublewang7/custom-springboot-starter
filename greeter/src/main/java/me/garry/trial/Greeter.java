package me.garry.trial;

import org.joda.time.DateTime;

public class Greeter {
    private static final String GREETING_FORMAT = "Good %s! %s.";
    private String name;

    public Greeter(String name) {
        this.name = name;
    }

    public String greet() {
        DateTime now = new DateTime();
        int hourOfDay = now.getHourOfDay();
        if(hourOfDay < 12 && hourOfDay >=0) {
            return String.format(GREETING_FORMAT, "morning", name);
        } else if (hourOfDay == 12) {
            return String.format(GREETING_FORMAT, "noon", name);
        } else {
            return String.format(GREETING_FORMAT, "afternoon", name);
        }
    }
}
