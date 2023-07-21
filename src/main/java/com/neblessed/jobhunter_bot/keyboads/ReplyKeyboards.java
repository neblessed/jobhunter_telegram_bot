package com.neblessed.jobhunter_bot.keyboads;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReplyKeyboards {

    public ReplyKeyboardMarkup mainMenu() {
        String enableSearchMode = "Включить приём вакансий ▶";
        String createFilter = "Создать фильтр 📟";
        String myFilters = "Мои фильтры ⚡";
        String clearFilters = "Сбросить фильтры 🗑";

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow rowOne = new KeyboardRow();
        rowOne.add(enableSearchMode);

        KeyboardRow rowTwo = new KeyboardRow();
        rowTwo.add(createFilter);
        rowTwo.add(myFilters);


        KeyboardRow rowThree = new KeyboardRow();
        rowThree.add(clearFilters);

        keyboard.add(rowOne);
        keyboard.add(rowTwo);
        keyboard.add(rowThree);

        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }

    public ReplyKeyboardMarkup searchMenu() {
        String disableSearchMode = "Пауза ⏸";
        String myFilters = "Мои фильтры ⚡";

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow rowOne = new KeyboardRow();
        rowOne.add(disableSearchMode);

        KeyboardRow rowTwo = new KeyboardRow();
        rowTwo.add(myFilters);

        keyboard.add(rowOne);
        keyboard.add(rowTwo);

        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }
}
