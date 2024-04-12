package com.bori.project31.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Level {
    private int loexp;
    private int hiexp;
    @Id
    private String grade;
}
