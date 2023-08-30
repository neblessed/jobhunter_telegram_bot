package com.neblessed.jobhunter_bot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "filters")
@Data
public class Filters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "job")
    private int job;
    @Column(name = "grade")
    private int grade;
    @Column(name = "chat_id")
    private int chatId;
    @Column(name = "user")
    private int user;
}
