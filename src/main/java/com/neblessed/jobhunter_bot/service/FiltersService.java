package com.neblessed.jobhunter_bot.service;

import com.neblessed.jobhunter_bot.model.Filters;

public interface FiltersService {
    String getFilterByChatId(int chatId);

    void saveFilter(Filters filters, int chatId) throws Exception;

    void deleteFilter(int chatId);
}
