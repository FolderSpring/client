package com.cheetah.client;

import com.cheetah.client.constants.Constants;
import com.cheetah.client.tasks.ScheduledTaskReadCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Timer;

@SpringBootApplication
@EnableJpaRepositories
public class ClientApplication implements CommandLineRunner {

    @Autowired
    private ScheduledTaskReadCsv scheduledTaskReadCsv;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Timer timer = new Timer();
        timer.schedule(scheduledTaskReadCsv, scheduledTaskReadCsv.getTomorrowMorning2AM(), Constants.ONCE_PER_DAY);
    }
}
