package com.neblessed.jobhunter_bot.messages;

import com.neblessed.jobhunter_bot.keyboads.ReplyKeyboards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class TelegramMessages {
    @Autowired
    ReplyKeyboards replyKeyboards;

    public SendMessage firstInfoMessage(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Привет, воспользуйся меню 👇🏼")
                .replyMarkup(replyKeyboards.mainMenu())
                .build();

        return message;
    }

    public SendMessage searchModeEnabled(long chatId){
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Режим приема вакансий включён ✔")
                .replyMarkup(replyKeyboards.searchMenu())
                .build();

        return message;
    }

    public SendMessage searchModeDisabled(long chatId){
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Режим приема вакансий приостановлен ⏸")
                .replyMarkup(replyKeyboards.mainMenu())
                .build();

        return message;
    }
}
