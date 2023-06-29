package com.neblessed.jobhunter_bot.service;

import com.neblessed.jobhunter_bot.model.Filters;
import com.neblessed.jobhunter_bot.repository.FiltersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeadhunterApiServiceImpl implements  HeadhunterApiService{

    @Autowired
    FiltersRepository filtersRepository;

    @Override
    public void getVacancy(Filters filter) {

    }

    @Override
    public void getAllVacanciesPerDay(Filters filter) {

    }
}
