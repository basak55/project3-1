package com.bori.project31.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemberRank {
    private int mno;
    private String mid;
    private String mpw;
    private String name;
    private String gender;
    private int exp;
    private String mintro;
    private int ranking;
    private String grade;
}
