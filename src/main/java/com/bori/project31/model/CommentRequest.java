package com.bori.project31.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequest {
    private int cno;
    private int guestbookmno;
    private String content;
    private String writer;
}
