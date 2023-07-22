package com.neblessed.jobhunter_bot.keyboad;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class InlineKeyboards {

    public InlineKeyboardMarkup jobPosition() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowOne;
        List<InlineKeyboardButton> rowTwo;

        InlineKeyboardButton qa = InlineKeyboardButton.builder()
                .text("QA Engineer")
                .callbackData("qaEngineer")
                .build();

        InlineKeyboardButton aqa = InlineKeyboardButton.builder()
                .text("QA Automation")
                .callbackData("aqaEngineer")
                .build();

        rowOne = List.of(qa, aqa);

        InlineKeyboardButton frontDev = InlineKeyboardButton.builder()
                .text("Frontend Developer")
                .callbackData("frontDev")
                .build();

        InlineKeyboardButton backDev = InlineKeyboardButton.builder()
                .text("Backend Developer")
                .callbackData("backDev")
                .build();
        rowTwo = List.of(frontDev, backDev);

        rowsInLine.add(rowOne);
        rowsInLine.add(rowTwo);
        inlineKeyboardMarkup.setKeyboard(rowsInLine);

        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup jobGrade() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowOne;


        InlineKeyboardButton junior = InlineKeyboardButton.builder()
                .text("Junior")
                .callbackData("junior")
                .build();

        InlineKeyboardButton middle = InlineKeyboardButton.builder()
                .text("Middle")
                .callbackData("middle")
                .build();

        InlineKeyboardButton senior = InlineKeyboardButton.builder()
                .text("Senior")
                .callbackData("senior")
                .build();

        InlineKeyboardButton lead = InlineKeyboardButton.builder()
                .text("Lead")
                .callbackData("lead")
                .build();

        rowOne = List.of(junior, middle, senior, lead);
        rowsInLine.add(rowOne);
        inlineKeyboardMarkup.setKeyboard(rowsInLine);
        return inlineKeyboardMarkup;
    }
}
