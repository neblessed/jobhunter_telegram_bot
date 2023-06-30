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
    @Column(name = "language_id")
    private int languageId;
    @Column(name = "grade")
    private double grade;
    @Column(name = "preffered_salary")
    private int salary;
    @Column(name = "currency")
    private String currency;
}
