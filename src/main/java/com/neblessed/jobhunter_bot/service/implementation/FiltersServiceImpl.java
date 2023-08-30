package com.neblessed.jobhunter_bot.service.implementation;

import com.neblessed.jobhunter_bot.model.Filters;
import com.neblessed.jobhunter_bot.repository.FiltersRepository;
import com.neblessed.jobhunter_bot.service.FiltersService;
import org.springframework.beans.factory.annotation.Autowired;

public class FiltersServiceImpl implements FiltersService {
    @Autowired
    FiltersRepository filtersRepository;

    @Override
    public String getFilterByChatId(int chatId) {
        return null;
    }

    @Override
    public void saveFilter(Filters filters, int chatId) throws Exception {
        if (filtersRepository.findAll().stream().noneMatch(x -> x.getChatId() == chatId)) {
            filtersRepository.save(filters);
        } else throw new Exception("Что-то пошло не так при создании фильтра");
    }

    @Override
    public void deleteFilter(int chatId) {

    }
}
