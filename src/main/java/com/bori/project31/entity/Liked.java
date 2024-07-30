package com.bori.project31.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Liked {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeno;
    private int getlikedmno;   //눌린사람 (Guestbook mno)
    private int likemno;       //누른사람 (login mno)
    @Temporal(TemporalType.TIMESTAMP)
    private Date likedat;       //시간
    
}
