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

    public InlineKeyboardMarkup prefferedLocation() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine;
        List<InlineKeyboardButton> rowOne;
        List<InlineKeyboardButton> rowTwo;
        List<InlineKeyboardButton> rowThree;
        List<InlineKeyboardButton> rowFour;
        List<InlineKeyboardButton> rowFive;

        InlineKeyboardButton locationNoMatter = InlineKeyboardButton.builder()
                .text("Не важно")
                .callbackData("locationNoMatter")
                .build();

        InlineKeyboardButton locationRussia = InlineKeyboardButton.builder()
                .text("Россия")
                .callbackData("locationRussia")
                .build();

        InlineKeyboardButton locationBelarus = InlineKeyboardButton.builder()
                .text("Беларусь")
                .callbackData("locationBelarus")
                .build();

        InlineKeyboardButton locationKazakhstan = InlineKeyboardButton.builder()
                .text("Казахстан")
                .callbackData("locationKazakhstan")
                .build();

        InlineKeyboardButton locationCyprus = InlineKeyboardButton.builder()
                .text("Кипр")
                .callbackData("locationCyprus")
                .build();

        InlineKeyboardButton locationTurkey = InlineKeyboardButton.builder()
                .text("Турция")
                .callbackData("locationTurkey")
                .build();

        InlineKeyboardButton locationEngland = InlineKeyboardButton.builder()
                .text("Великобритания")
                .callbackData("locationEngland")
                .build();

        InlineKeyboardButton locationGermany = InlineKeyboardButton.builder()
                .text("Германия")
                .callbackData("locationGermany")
                .build();

        InlineKeyboardButton locationUSA = InlineKeyboardButton.builder()
                .text("США")
                .callbackData("locationUSA")
                .build();


        rowOne = List.of(locationNoMatter);
        rowTwo = List.of(locationRussia, locationBelarus);
        rowThree = List.of(locationKazakhstan, locationCyprus);
        rowFour = List.of(locationTurkey, locationGermany);
        rowFive = List.of(locationEngland, locationUSA);

        rowsInLine = List.of(rowOne, rowTwo, rowThree, rowFour, rowFive);
        inlineKeyboardMarkup.setKeyboard(rowsInLine);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup prefferedJobType() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine;
        List<InlineKeyboardButton> rowTwo;
        List<InlineKeyboardButton> rowThree;
        List<InlineKeyboardButton> rowFour;


        InlineKeyboardButton remote = InlineKeyboardButton.builder()
                .text("Удаленно")
                .callbackData("remote")
                .build();

        InlineKeyboardButton office = InlineKeyboardButton.builder()
                .text("Офис")
                .callbackData("office")
                .build();

        InlineKeyboardButton hybrid = InlineKeyboardButton.builder()
                .text("Гибрид")
                .callbackData("hybrid")
                .build();

        rowTwo = List.of(remote);
        rowThree = List.of(office);
        rowFour = List.of(hybrid);


        rowsInLine = List.of(rowTwo, rowThree, rowFour);
        inlineKeyboardMarkup.setKeyboard(rowsInLine);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup prefferedSalary() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine;
        List<InlineKeyboardButton> rowOne = new ArrayList<>();
        List<InlineKeyboardButton> rowTwo = new ArrayList<>();
        List<InlineKeyboardButton> rowThree = new ArrayList<>();

        InlineKeyboardButton k50plus = InlineKeyboardButton.builder()
                .text("50-80k RUB")
                .callbackData("50-80k")
                .build();

        InlineKeyboardButton k90plus = InlineKeyboardButton.builder()
                .text("90-120k RUB")
                .callbackData("90-120k")
                .build();

        InlineKeyboardButton k120plus = InlineKeyboardButton.builder()
                .text("120-150k RUB")
                .callbackData("120-150k")
                .build();

        rowOne.add(k50plus);
        rowTwo.add(k90plus);
        rowThree.add(k120plus);

        rowsInLine = List.of(rowOne, rowTwo, rowThree);
        inlineKeyboardMarkup.setKeyboard(rowsInLine);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup programmingLanguage() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine;
        List<InlineKeyboardButton> rowOne;
        List<InlineKeyboardButton> rowTwo;
        List<InlineKeyboardButton> rowThree;
        List<InlineKeyboardButton> rowFour;

        InlineKeyboardButton java = InlineKeyboardButton.builder()
                .text("Java")
                .callbackData("java")
                .build();

        InlineKeyboardButton python = InlineKeyboardButton.builder()
                .text("Python")
                .callbackData("python")
                .build();

        InlineKeyboardButton kotlin = InlineKeyboardButton.builder()
                .text("Kotlin")
                .callbackData("kotlin")
                .build();

        InlineKeyboardButton javaScript = InlineKeyboardButton.builder()
                .text("JavaScript")
                .callbackData("javaScript")
                .build();

        InlineKeyboardButton golang = InlineKeyboardButton.builder()
                .text("Golang")
                .callbackData("golang")
                .build();

        InlineKeyboardButton c = InlineKeyboardButton.builder()
                .text("C")
                .callbackData("c")
                .build();

        InlineKeyboardButton programmingLanguageNoMatter = InlineKeyboardButton.builder()
                .text("Пропустить")
                .callbackData("programmingLanguageNoMatter")
                .build();

        rowOne = List.of(java, python);
        rowTwo = List.of(javaScript, kotlin);
        rowThree = List.of(golang, c);
        rowFour = List.of(programmingLanguageNoMatter);

        rowsInLine = List.of(rowOne, rowTwo, rowThree, rowFour);
        inlineKeyboardMarkup.setKeyboard(rowsInLine);
        return inlineKeyboardMarkup;
    }
}
