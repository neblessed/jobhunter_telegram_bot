package com.neblessed.jobhunter_bot.service;

import com.neblessed.jobhunter_bot.model.Filters;

import java.util.List;

public interface FiltersService {

    String myFilter(int chatId);

    void saveFilter(Filters filter, int chatId) throws Exception;
}
