package com.neblessed.jobhunter_bot.repository;

import com.neblessed.jobhunter_bot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
