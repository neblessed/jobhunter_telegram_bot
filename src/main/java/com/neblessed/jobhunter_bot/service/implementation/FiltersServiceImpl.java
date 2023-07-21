package com.neblessed.jobhunter_bot.service.implementation;

import com.neblessed.jobhunter_bot.helpers.RequestData;
import com.neblessed.jobhunter_bot.model.Filters;
import com.neblessed.jobhunter_bot.repository.UsersRepository;
import com.neblessed.jobhunter_bot.service.FiltersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltersServiceImpl implements FiltersService {
    @Autowired
    RequestData requestData;
    @Autowired
    UsersRepository usersRepository;


    @Override
    public String myFilter(int chatId) {
        if (usersRepository.findAll().stream().anyMatch(x -> x.getTgUserId() == chatId)) {
            return "Позиция: " + requestData.getJobTitle(chatId) + "\n"
                    + "Грейд: " + requestData.getGrade(chatId) + "\n"
                    + "Предпочитаемая локация: " + requestData.getPrefferedLocation(chatId) + "\n"
                    + "Зарплата: " + requestData.getSalary(chatId);
        } else return "У Вас ещё не создано ни одного фильтра.\n" + "Нажмите на [Создать фильтр 📟]";
    }

    @Override
    public Filters saveFilter(List<String> parameters) {

        return null;
    }
}
