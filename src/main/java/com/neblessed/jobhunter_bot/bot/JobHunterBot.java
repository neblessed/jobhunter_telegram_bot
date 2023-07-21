package com.neblessed.jobhunter_bot.bot;

import com.neblessed.jobhunter_bot.service.HeadhunterApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class JobHunterBot extends TelegramLongPollingBot {
    @Autowired
    HeadhunterApiServiceImpl hh;

    public JobHunterBot(@Value("${bot.token}") String token) {
        super(token);
    }

    @Override
    public void onUpdateReceived(Update update) {
    }

    @Override
    public String getBotUsername() {
        return "IT_JobHunterBot";
    }
}
