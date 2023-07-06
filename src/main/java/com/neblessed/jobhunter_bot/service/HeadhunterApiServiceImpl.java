package com.neblessed.jobhunter_bot.service;

import com.neblessed.jobhunter_bot.helpers.RequestData;
import com.neblessed.jobhunter_bot.model.headhunter_model.HhPojo;
import com.neblessed.jobhunter_bot.repository.FiltersRepository;
import com.neblessed.jobhunter_bot.repository.JobsRepository;
import com.neblessed.jobhunter_bot.repository.UsersRepository;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@Service
public class HeadhunterApiServiceImpl implements HeadhunterApiService {
    @Autowired
    RequestData data;

    @Override
    public List<HhPojo> getAllVacanciesPerDay(int chatId) {
        int filterId = data.getFilterId(chatId);
        int jobId = data.getJobId(chatId);
        String jobName = data.getJobTitle(chatId);
        String grade = data.getGrade(chatId);
        int salary = data.getSalary(chatId);
        String currency = data.getCurrency(chatId);

        String prefferedLocation = data.getPrefferedLocation(chatId);

        //QueryParams
        String jobWithDrageQuery = jobName + " " + grade;
        //TODO add period parameter

        //TEST DATA FROM POJO
        List<HhPojo> hh = given()
                .contentType(ContentType.JSON)
                .queryParam("text", jobWithDrageQuery)
                .queryParam("only_with_salary", true)
                .when()
                .get("https://api.hh.ru/vacancies")
                .then()
                .extract().body().jsonPath()
                .getList("items", HhPojo.class);

        System.out.println("Ссылка на вакансию: " + hh.get(1).getAlternate_url());
        System.out.println("Компания: " + hh.get(1).getEmployer().name);
        System.out.println("Акредитованная компания: " + hh.get(1).getEmployer().accredited_it_employer);
        System.out.println("Название вакансии: " + hh.get(1).getName());
        System.out.println("Локация: " + hh.get(1).getArea().name);
        System.out.println("Тип работы: " + hh.get(1).getEmployment().name);
        System.out.println("Требуемый опыт: " + hh.get(1).getExperience().name);
        System.out.println("Зарплата: от " + hh.get(1).getSalary().from + " до " + hh.get(1).getSalary().myto + " " + hh.get(1).getSalary().currency);

        return hh;
    }
}
