package me.garry.trial.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TestTask implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(TestTask.class);

    private int index;

    public TestTask(final int index) {
        this.index = index;
    }

    @Override
    public void run() {
        try {
            logger.info("test task {} is running", this.index);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            logger.warn("test task {} was interrupted.", this.index);
        }
    }
}
