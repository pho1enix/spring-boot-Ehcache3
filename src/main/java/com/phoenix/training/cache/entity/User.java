package com.phoenix.training.cache.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 23022019160956L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fname;
    private String age;
    private String city;
}
