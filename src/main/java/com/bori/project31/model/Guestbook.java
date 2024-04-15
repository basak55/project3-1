package com.bori.project31.model;

import lombok.Getter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
public class Guestbook { //CommentResponse

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


