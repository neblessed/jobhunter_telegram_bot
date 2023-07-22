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
    @Column(name = "preffered_location")
    private String prefferedLocation;
    @Column(name = "job_id")
    private int jobId;
    @Column(name = "job_typ")
    private int jobTyp;
    @Column(name = "language_id")
    private int languageId;
    @Column(name = "grade_id")
    private int gradeId;
    @Column(name = "preffered_salary")
    private int prefferedSalary;
    @Column(name = "currency_id")
    private int currencyId;
    @Column(name = "telegram_id")
    private int telegram_id;
}
