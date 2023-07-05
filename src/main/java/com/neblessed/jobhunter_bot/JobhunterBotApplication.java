package com.neblessed.jobhunter_bot;

import com.neblessed.jobhunter_bot.service.HeadhunterApiServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JobhunterBotApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JobhunterBotApplication.class, args);
        HeadhunterApiServiceImpl hh = context.getBean(HeadhunterApiServiceImpl.class);
        hh.getAllVacanciesPerDay(44);

    }

}
