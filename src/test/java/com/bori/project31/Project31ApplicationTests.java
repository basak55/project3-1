package com.bori.project31;

import com.bori.project31.model.Member;
import com.bori.project31.model.MemberRequest;
import com.bori.project31.model.Record;
import com.bori.project31.repository.MemberMapper;

import com.bori.project31.repository.RecordMapper;
import com.bori.project31.service.MemberInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class Project31ApplicationTests {

    @Autowired
    MemberMapper memberMapper;
    @Autowired
    RecordMapper recordMapper;
    @Autowired
    MemberInfoService memberInfoService;

    @Test
    public void rank(){
        log.info("list: {}",memberInfoService.selectMemberRank());
    }


//    @Test
//    void insert(){
//        MemberRequest memberReq = MemberRequest.builder().mid("a").mpw("a").name("a").gender("F").mintro("a").build();
//        memberInfoService.insertMember(member);
//        log.info("생성된 멤버 {}",memberMapper.selectByMno(memberReq.getMno()));
//        log.info("생성된 record {}",recordMapper.selectRecord());
//    }

//    @Test
//    void contextLoads() {
//        MemberRequest memberReq = MemberRequest.builder().mid("a").mpw("a").name("a").gender("F").mintro("a").build();
//        memberMapper.insertMember(memberReq);
//        log.info("생성된 mno: {}",memberReq.getMno());
//    }


}
