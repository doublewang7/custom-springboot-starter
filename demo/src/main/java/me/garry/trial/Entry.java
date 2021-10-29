package me.garry.trial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;


@SpringBootApplication
@EnableMBeanExport
public class Entry {
    public static void main(String[] args) {
        SpringApplication.run(Entry.class, args);
    }

}
