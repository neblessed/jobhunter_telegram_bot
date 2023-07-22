package com.neblessed.jobhunter_bot.message;

import com.neblessed.jobhunter_bot.keyboad.InlineKeyboards;
import com.neblessed.jobhunter_bot.keyboad.ReplyKeyboards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class FilterParamsMessages {
    @Autowired
    InlineKeyboards inlineKeyboards;


    public SendMessage addYourJob(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Выберите Вашу позицию: ")
                .replyMarkup(inlineKeyboards.jobPosition())
                .build();
        return message;
    }

    public SendMessage addYourGrade(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Выберите Ваш грейд: ")
                .replyMarkup(inlineKeyboards.jobGrade())
                .build();
        return message;
    }

    public SendMessage prefferedJobType(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Предпочитаемый вид занятости: ")
                .replyMarkup(inlineKeyboards.prefferedJobType())
                .build();
        return message;
    }

    public SendMessage prefferedLocation(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Предпочитаемая страна компании: ")
                .replyMarkup(inlineKeyboards.prefferedLocation())
                .build();
        return message;
    }

    public SendMessage prefferedSalary(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Предпочитаемая ЗП: ")
                .replyMarkup(inlineKeyboards.prefferedSalary())
                .build();
        return message;
    }

    public SendMessage programmingLanguage(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Язык программирования: ")
                .replyMarkup(inlineKeyboards.programmingLanguage())
                .build();
        return message;
    }

    public SendMessage filterCreated(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Ваш фильтр успешно создан 👌🏼")
                .build();
        return message;
    }
}
