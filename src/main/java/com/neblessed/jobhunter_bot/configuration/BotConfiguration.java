package com.neblessed.jobhunter_bot.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BotConfiguration {

    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;

}
