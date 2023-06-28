package com.neblessed.jobhunter_bot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "job_types")
@Data
public class JobTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "job_typ")
    private String jobTyp;
}
