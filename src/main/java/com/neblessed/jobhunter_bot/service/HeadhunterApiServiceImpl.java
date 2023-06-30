package com.neblessed.jobhunter_bot.service;

import com.neblessed.jobhunter_bot.model.Filters;
import com.neblessed.jobhunter_bot.repository.FiltersRepository;
import com.neblessed.jobhunter_bot.repository.JobsRepository;
import com.neblessed.jobhunter_bot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeadhunterApiServiceImpl implements HeadhunterApiService {

    @Autowired
    FiltersRepository filtersRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Override
    public void getVacancy(Filters filter) {
    }

    @Override
    public void getAllVacanciesPerDay(Filters filter, int chatId) {
        //text params
        int filterId = usersRepository.findAll()
                .stream()
                .filter(x -> x.getTgUserId() == chatId)
                .findFirst()
                .get()
                .getFilterId();
        int jobId = filtersRepository.findById(filterId).get().getJobId();
        String jobName = jobsRepository.findById(jobId).get().getJobTitle();
        String grage = filtersRepository.findById(filterId).get().getGrade();

        //salary params
        int salary = filtersRepository.findById(filterId).get().getPrefferedSalary();
        String currency = filtersRepository.findById(filterId).get().getCurrency();

        //period params


    }
}
