package com.neblessed.jobhunter_bot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "last_use")
    private String lastUse;
}
