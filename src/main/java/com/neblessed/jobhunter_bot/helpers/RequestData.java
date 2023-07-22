package com.neblessed.jobhunter_bot.helpers;

import com.neblessed.jobhunter_bot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestData {
    @Autowired
    FiltersRepository filtersRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    GradesRepository gradesRepository;

    @Autowired
    CurrencyRepository currencyRepository;


    public int getFilterId(int chatId) {
        return filtersRepository
                .findAll()
                .stream()
                .filter(x -> x.getTelegram_id() == chatId)
                .findFirst()
                .get()
                .getId();
    }

    public int getJobId(int chatId) {
        return filtersRepository
                .findById(getFilterId(chatId))
                .get()
                .getJobId();
    }

    public String getJobTitle(int chatId) {
        return jobsRepository
                .findById(getJobId(chatId))
                .get()
                .getJobTitle();
    }

    public String getGrade(int chatId) {
        int gradeId = filtersRepository
                .findById(getFilterId(chatId))
                .get()
                .getGradeId();

        return gradesRepository
                .findById(gradeId)
                .get()
                .getGrade();
    }

    public int getSalary(int chatId) {
        return filtersRepository
                .findById(getFilterId(chatId))
                .get()
                .getPrefferedSalary();
    }

    public String getCurrency(int chatId) {
        int currencyId = filtersRepository
                .findById(getFilterId(chatId))
                .get()
                .getCurrencyId();

        return currencyRepository
                .findById(currencyId)
                .get()
                .getCurrecy();
    }

    public String getPrefferedLocation(int chatId) {
        return filtersRepository
                .findById(getFilterId(chatId))
                .get()
                .getPrefferedLocation();
    }
}
