package com.neblessed.jobhunter_bot.service.implementation;

import com.neblessed.jobhunter_bot.helpers.RequestData;
import com.neblessed.jobhunter_bot.model.Filters;
import com.neblessed.jobhunter_bot.repository.FiltersRepository;
import com.neblessed.jobhunter_bot.service.FiltersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiltersServiceImpl implements FiltersService {
    @Autowired
    RequestData requestData;
    @Autowired
    FiltersRepository filtersRepository;


    @Override
    public String myFilter(int chatId) {
        if (filtersRepository.findAll().stream().anyMatch(x -> x.getTelegram_id() == chatId)) {
            return "Позиция: " + requestData.getJobTitle(chatId) + "\n"
                    + "Грейд: " + requestData.getGrade(chatId) + "\n"
                    + "Предпочитаемая локация: " + requestData.getPrefferedLocation(chatId) + "\n"
                    + "Зарплата: " + requestData.getSalary(chatId);
        } else return "Вы ещё не создали фильтр.\n" + "Нажмите на [Создать фильтр 📟]";
    }

    @Override
    public void saveFilter(Filters filter, int chatId) throws Exception {
        if (filtersRepository.findAll().stream().allMatch(x -> x.getTelegram_id() != chatId)) {
            filtersRepository.save(filter);
        } else throw new Exception("Что-то пошло не так при создании фильтра");
    }
}
