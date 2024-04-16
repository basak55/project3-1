package com.bori.project31.repository;

import com.bori.project31.model.CommentRequest;
import com.bori.project31.model.Guestbook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuestbookMapper {
    
    public void save(CommentRequest params); //파라미터로 받아올 정보

    Guestbook findCommentByCno(int cno);

    void update(CommentRequest params);
    
    void deleteByCno(int cno);
    
    List<Guestbook> findAll(int mno);
    
    int count(int mno); //댓글수

}
