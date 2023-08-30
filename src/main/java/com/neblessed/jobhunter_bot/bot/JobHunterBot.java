package com.neblessed.jobhunter_bot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class JobHunterBot extends TelegramLongPollingBot {

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


    public DeleteMessage deleteLatestMessage(long chatId, long messageId) {
        return DeleteMessage.builder().chatId(chatId).messageId((int) messageId).build();
    }
}
