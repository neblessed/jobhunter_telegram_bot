package com.neblessed.jobhunter_bot.service;

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
    FiltersRepository filtersRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Override
    public List<HhPojo> getAllVacanciesPerDay(int chatId) {
        //text params
        int filterId = usersRepository.findAll()
                .stream()
                .filter(x -> x.getTgUserId() == chatId)
                .findFirst()
                .get()
                .getFilterId();

        int jobId = filtersRepository.findById(filterId).get().getJobId();
        String jobName = jobsRepository.findById(jobId).get().getJobTitle();
        String grade = filtersRepository.findById(filterId).get().getGrade();

        //salary params
        int salary = filtersRepository.findById(filterId).get().getPrefferedSalary();
        String currency = filtersRepository.findById(filterId).get().getCurrency();

        //period params
        //TODO add period parameter

        //TEST DATA FROM POJO
        List<HhPojo> hh = given()
                .contentType(ContentType.JSON)
                .queryParam("text", jobName + " " + grade)
                .queryParam("only_with_salary", true)
                .when()
                .get("https://api.hh.ru/vacancies")
                .then()
                .extract().body().jsonPath()
                .getList("items", HhPojo.class);

        System.out.println("Ссылка на вакансию: " + hh.get(1).getAlternate_url());
        System.out.println("Компания: " + hh.get(1).getEmployer().name);
        System.out.println("Название вакансии: " + hh.get(1).getName());
        System.out.println("Локация: " + hh.get(1).getArea().name);
        System.out.println("Тип работы: " + hh.get(1).getEmployment().name);
        System.out.println("Требуемый опыт: " + hh.get(1).getExperience().name);
        System.out.println("Зарплата: от " + hh.get(1).getSalary().from + " до " + hh.get(1).getSalary().myto + " " + hh.get(1).getSalary().currency);

        return hh;

    }
}
