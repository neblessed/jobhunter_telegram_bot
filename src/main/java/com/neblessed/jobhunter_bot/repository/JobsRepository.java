package com.neblessed.jobhunter_bot.repository;

import com.neblessed.jobhunter_bot.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, Integer> {
}
