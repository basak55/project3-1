package com.bori.project31.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Guestbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;
    private int mno; //방명록 소유자
    private String content;
    private String writer; //방명록 쓴사람
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    private Boolean deleteYn;

}
