package com.neblessed.jobhunter_bot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "currency")
@Data
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "currency")
    private String currecy;
}
