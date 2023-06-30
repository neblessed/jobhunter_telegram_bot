package com.neblessed.jobhunter_bot.service;

import com.neblessed.jobhunter_bot.model.Filters;

public interface HeadhunterApiService {
    void getVacancy(Filters filter);

    void getAllVacanciesPerDay(Filters filter, int chatId);
}
