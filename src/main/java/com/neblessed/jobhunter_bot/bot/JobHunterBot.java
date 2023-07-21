package com.neblessed.jobhunter_bot.bot;

import com.neblessed.jobhunter_bot.messages.TelegramMessages;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class JobHunterBot extends TelegramLongPollingBot {
    @Autowired
    TelegramMessages messages;

    public JobHunterBot(@Value("${bot.token}") String token) {
        super(token);
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            String message = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (message) {
                case "/start" -> execute(messages.firstInfoMessage(chatId));
                case "Включить приём вакансий ▶" -> execute(messages.searchModeEnabled(chatId));
                case "Пауза ⏸" -> execute(messages.searchModeDisabled(chatId));
                case "Мои фильтры ⚡" -> execute(messages.userFilter(chatId));
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "IT_JobHunterBot";
    }
}
