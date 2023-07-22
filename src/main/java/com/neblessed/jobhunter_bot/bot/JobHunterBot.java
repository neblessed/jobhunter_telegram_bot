package com.neblessed.jobhunter_bot.bot;

import com.neblessed.jobhunter_bot.message.FilterParamsMessages;
import com.neblessed.jobhunter_bot.message.TelegramMessages;
import com.neblessed.jobhunter_bot.model.Filters;
import com.neblessed.jobhunter_bot.service.implementation.FiltersServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class JobHunterBot extends TelegramLongPollingBot {
    Filters filter = new Filters();

    @Autowired
    TelegramMessages messages;

    @Autowired
    FilterParamsMessages filterMessages;

    @Autowired
    FiltersServiceImpl filtersService;

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


            switch (callBack) {
                case "qaEngineer" -> {
                    filter.setJobId(1);
                    filter.setTelegram_id((int) chatId);
                    filter.setCurrencyId(1);
                    execute(filterMessages.addYourGrade(chatId));
                }
                case "aqaEngineer" -> {
                    filter.setJobId(4);
                    filter.setTelegram_id((int) chatId);
                    filter.setCurrencyId(1);
                    execute(filterMessages.addYourGrade(chatId));
                }
                case "frontDev" -> {
                    filter.setJobId(2);
                    filter.setTelegram_id((int) chatId);
                    filter.setCurrencyId(1);
                    execute(filterMessages.addYourGrade(chatId));
                }
                case "backDev" -> {
                    filter.setJobId(3);
                    filter.setTelegram_id((int) chatId);
                    filter.setCurrencyId(1);
                    execute(filterMessages.addYourGrade(chatId));
                }


                case "junior" -> {
                    filter.setGradeId(2);
                    execute(filterMessages.prefferedJobType(chatId));
                }
                case "middle" -> {
                    filter.setGradeId(3);
                    execute(filterMessages.prefferedJobType(chatId));
                }
                case "senior" -> {
                    filter.setGradeId(4);
                    execute(filterMessages.prefferedJobType(chatId));
                }
                case "lead" -> {
                    filter.setGradeId(5);
                    execute(filterMessages.prefferedJobType(chatId));
                }


                case "remote" -> {
                    filter.setJobTyp(1);
                    execute(filterMessages.prefferedLocation(chatId));
                }
                case "office" -> {
                    filter.setJobTyp(2);
                    execute(filterMessages.prefferedLocation(chatId));
                }
                case "hybrid" -> {
                    filter.setJobTyp(3);
                    execute(filterMessages.prefferedLocation(chatId));
                }
                case "typeNoMatter" -> execute(filterMessages.prefferedLocation(chatId));


                case "locationNoMatter" -> execute(filterMessages.prefferedSalary(chatId));
                case "locationRussia" -> {
                    filter.setPrefferedLocation("Россия");
                    execute(filterMessages.programmingLanguage(chatId));
                }
                case "locationBelarus" -> {
                    filter.setPrefferedLocation("Беларусь");
                    execute(filterMessages.programmingLanguage(chatId));
                }
                case "locationKazakhstan" -> {
                    filter.setPrefferedLocation("Казахстан");
                    execute(filterMessages.programmingLanguage(chatId));
                }
                case "locationCyprus" -> {
                    filter.setPrefferedLocation("Кипр");
                    execute(filterMessages.programmingLanguage(chatId));
                }
                case "locationTurkey" -> {
                    filter.setPrefferedLocation("Турция");
                    execute(filterMessages.programmingLanguage(chatId));
                }
                case "locationEngland" -> {
                    filter.setPrefferedLocation("Великобритания");
                    execute(filterMessages.programmingLanguage(chatId));
                }
                case "locationGermany" -> {
                    filter.setPrefferedLocation("Германия");
                    execute(filterMessages.programmingLanguage(chatId));
                }
                case "locationUSA" -> {
                    filter.setPrefferedLocation("США");
                    execute(filterMessages.programmingLanguage(chatId));
                }
                case "java" -> {
                    filter.setLanguageId(1);
                    execute(filterMessages.prefferedSalary(chatId));
                }
                case "python" -> {
                    filter.setLanguageId(2);
                    execute(filterMessages.prefferedSalary(chatId));
                }
                case "javaScript" -> {
                    filter.setLanguageId(3);
                    execute(filterMessages.prefferedSalary(chatId));
                }
                case "kotlin" -> {
                    filter.setLanguageId(4);
                    execute(filterMessages.prefferedSalary(chatId));
                }
                case "golang" -> {
                    filter.setLanguageId(5);
                    execute(filterMessages.prefferedSalary(chatId));
                }
                case "c" -> {
                    filter.setLanguageId(6);
                    execute(filterMessages.prefferedSalary(chatId));
                }
                case "programmingLanguageNoMatter" -> execute(filterMessages.prefferedSalary(chatId));
                case "50-80k" -> {
                    filter.setPrefferedSalary(60000);
                    execute(filterMessages.filterCreated(chatId));
                    filtersService.saveFilter(filter, (int) chatId);
                }
                case "90-120k" -> {
                    filter.setPrefferedSalary(90000);
                    execute(filterMessages.filterCreated(chatId));
                    filtersService.saveFilter(filter, (int) chatId);
                }
                case "120-150k" -> {
                    filter.setPrefferedSalary(12000);
                    execute(filterMessages.filterCreated(chatId));
                    System.out.println(filter);
                    filtersService.saveFilter(filter, (int) chatId);
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "IT_JobHunterBot";
    }
}
