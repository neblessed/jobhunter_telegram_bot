package com.neblessed.jobhunter_bot.repository;

import com.neblessed.jobhunter_bot.model.Grades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradesRepository extends JpaRepository<Grades, Integer> {
}
