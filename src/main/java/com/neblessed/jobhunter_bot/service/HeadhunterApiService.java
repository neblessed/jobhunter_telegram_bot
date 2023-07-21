package com.neblessed.jobhunter_bot.service;

import com.neblessed.jobhunter_bot.model.headhunter_model.HhPojo;

import java.io.IOException;
import java.util.List;

public interface HeadhunterApiService {

    List<HhPojo> getAllVacanciesPerDay(int chatId) throws IOException, InterruptedException;

}
