package com.neblessed.jobhunter_bot.repository;

import com.neblessed.jobhunter_bot.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
