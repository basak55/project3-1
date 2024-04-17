package com.bori.project31.service;

import com.bori.project31.model.CommentRequest;
import com.bori.project31.model.Guestbook;
import com.bori.project31.repository.GuestbookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestbookService {

    @Autowired
    GuestbookMapper guestbookMapper;

    //댓글 저장
    @Transactional
    public int saveComment(CommentRequest params){
        guestbookMapper.save(params);
        return params.getCno();
    }

    //상세조회
    public Guestbook findCommentByCno(int cno){
        return guestbookMapper.findCommentByCno(cno);
    }

    //수정
    public int updateComment(CommentRequest params){
        guestbookMapper.update(params);
        return params.getCno();
    }

    //삭제
    @Transactional
    public int deleteComment(int cno) {
        guestbookMapper.deleteByCno(cno);
        return cno;
    }

    //리스트 조회
    public List<Guestbook> findAllComment(int mno){
        return guestbookMapper.findAll(mno);
    }


}
