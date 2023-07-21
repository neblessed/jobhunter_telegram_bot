package com.neblessed.jobhunter_bot.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "telegram_user_id")
    private int tgUserId;
    @Column(name = "current_location")
    private String currentLocation;
    @Column(name = "filter_id")
    private int filterId;
}
