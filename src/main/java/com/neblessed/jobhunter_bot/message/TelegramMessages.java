package com.neblessed.jobhunter_bot.message;

import com.neblessed.jobhunter_bot.keyboad.ReplyKeyboards;
import com.neblessed.jobhunter_bot.repository.FiltersRepository;
import com.neblessed.jobhunter_bot.service.implementation.FiltersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class TelegramMessages {
    @Autowired
    ReplyKeyboards replyKeyboards;
    @Autowired
    FiltersServiceImpl filtersService;
    @Autowired
    FiltersRepository filtersRepository;

    public SendMessage firstInfoMessage(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Привет, воспользуйся меню 👇🏼")
                .replyMarkup(replyKeyboards.mainMenu())
                .build();

        return message;
    }

    public SendMessage searchModeEnabled(long chatId) {
        if (filtersRepository.findAll().stream().anyMatch(x -> x.getTelegram_id() == chatId)) {
            SendMessage message = SendMessage
                    .builder()
                    .chatId(chatId)
                    .text("Режим приема вакансий включён ✅\n"
                            + "\nТеперь вы будете получать предложения о работе согласно созданному фильтру.")
                    .replyMarkup(replyKeyboards.searchMenu())
                    .build();
            return message;
        } else {
            SendMessage message = SendMessage
                    .builder()
                    .chatId(chatId)
                    .text("Отсутствует фильтр для поиска ❌\n"
                    +"\nДля начала создайте его")
                    .build();
            return message;
        }
    }

    public SendMessage searchModeDisabled(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text("Режим приема вакансий остановлен ⏸")
                .replyMarkup(replyKeyboards.mainMenu())
                .build();

        return message;
    }

    public SendMessage userFilter(long chatId) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text(filtersService.myFilter((int) chatId))
                .replyMarkup(replyKeyboards.mainMenu())
                .build();

        return message;
    }
}
