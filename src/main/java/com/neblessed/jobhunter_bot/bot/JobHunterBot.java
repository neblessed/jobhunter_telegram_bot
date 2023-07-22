package com.neblessed.jobhunter_bot.bot;

import com.neblessed.jobhunter_bot.message.FilterParamsMessages;
import com.neblessed.jobhunter_bot.message.TelegramMessages;
import com.neblessed.jobhunter_bot.model.Filters;
import lombok.SneakyThrows;
import org.glassfish.jersey.server.internal.JsonWithPaddingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class JobHunterBot extends TelegramLongPollingBot {
    @Autowired
    TelegramMessages messages;

    @Autowired
    FilterParamsMessages filterMessages;

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
                case "Мой фильтр ⚡" -> execute(messages.userFilter(chatId));
                case "Создать фильтр 📟" -> execute(filterMessages.addYourJob(chatId));
            }
        } else if (update.hasCallbackQuery()) {
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            String callBack = update.getCallbackQuery().getData();
            Filters filter = new Filters();

            switch (callBack) {
                case "qaEngineer" -> {
                    filter.setJobId(1);
                    execute(filterMessages.addYourGrade(chatId));
                }
                case "aqaEngineer" -> {
                    filter.setJobId(4);
                    execute(filterMessages.addYourGrade(chatId));
                }
                case "frontDev" -> {
                    filter.setJobId(2);
                    execute(filterMessages.addYourGrade(chatId));
                }
                case "backDev" -> {
                    filter.setJobId(3);
                    execute(filterMessages.addYourGrade(chatId));
                }
                case "junior" -> {
                    filter.setGradeId(2);
                    execute(filterMessages.prefferedLocation(chatId));
                }
                case "middle" -> {
                    filter.setJobId(3);
                    execute(filterMessages.prefferedLocation(chatId));
                }
                case "senior" -> {
                    filter.setJobId(4);
                    execute(filterMessages.prefferedLocation(chatId));
                }
                case "lead" -> {
                    filter.setJobId(5);
                    execute(filterMessages.prefferedLocation(chatId));
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "IT_JobHunterBot";
    }
}
