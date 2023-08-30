package com.neblessed.jobhunter_bot.helper;

import com.neblessed.jobhunter_bot.repository.FiltersRepository;
import com.neblessed.jobhunter_bot.repository.GradesRepository;
import com.neblessed.jobhunter_bot.repository.JobsRepository;
import com.neblessed.jobhunter_bot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RequestData {
    @Autowired
    FiltersRepository filtersRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    GradesRepository gradesRepository;
    @Autowired
    JobsRepository jobsRepository;


    public int getFilterId(int chatId) {
        return filtersRepository
                .findAll()
                .stream()
                .filter(x -> x.getChatId() == chatId)
                .findFirst()
                .get()
                .getId();
    }

    public int getJobId(int chatId) {
        return filtersRepository
                .findById(getFilterId(chatId))
                .get()
                .getJob();
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
                .getGrade();

        return gradesRepository
                .findById(gradeId)
                .get()
                .getGrade();
    }
}
