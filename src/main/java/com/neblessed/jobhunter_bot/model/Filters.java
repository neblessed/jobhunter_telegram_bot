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
    @Column(name = "experience_in_position")
    private double experienceInPosition; //example: 0.1 - 1 month
}
