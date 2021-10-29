package me.garry.trial;

import me.garry.trial.tasks.CustomRejectedExecutionHandler;
import me.garry.trial.tasks.TestTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Component
@ManagedResource(
        objectName = "bean:name=testThreadPool",
        description = "Thread Pool",
        log = true,
        logFile = "jmx.log"
)
public class AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);
    private ThreadPoolExecutor executor;

    @PostConstruct
    private void init() {
        executor = new ThreadPoolExecutor(
                1,
                3,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new CustomRejectedExecutionHandler());
        executor.prestartAllCoreThreads();
    }

    public void launch() {
        IntStream.range(1,10).forEachOrdered(i -> {
            TestTask tt = new TestTask(i);
            executor.execute(tt);
        });
    }

    @ManagedAttribute(description = "available threads")
    public int getSize() {
        return executor.getPoolSize();
    }
}
