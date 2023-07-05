package com.neblessed.jobhunter_bot.service;

import com.neblessed.jobhunter_bot.model.headhunter_model.Items;

import java.io.IOException;
import java.util.List;

public interface HeadhunterApiService {

    List<Items> getAllVacanciesPerDay(int chatId) throws IOException, InterruptedException;

}
