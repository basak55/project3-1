package com.bori.project31.controller;

import com.bori.project31.model.CommentRequest;
import com.bori.project31.model.Guestbook;
import com.bori.project31.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentApiController {

    private final GuestbookService guestbookService;

    //새 댓글
    @PostMapping("/posts/{guestbookmno}/comments")
    public Guestbook saveComment(@PathVariable final int guestbookmno, @RequestBody final CommentRequest params) {
        int cno = guestbookService.saveComment(params);
        return guestbookService.findCommentByCno(cno);
    }

    //목록 불러오기
    @GetMapping("/posts/{mno}/comments")
    public List<Guestbook> findAllComment(@PathVariable final int mno){
        return guestbookService.findAllComment(mno);
    }

    //댓글 수정하기
    @PatchMapping("/posts/{mno}/comments/{cno}")
    public Guestbook updateComment(@PathVariable final int mno, @PathVariable final int cno, @RequestBody final CommentRequest params){
        guestbookService.updateComment(params);
        return guestbookService.findCommentByCno(cno);
    }

    //삭제
    @DeleteMapping("/posts/{mno}/comments/{cno}")
    public int deleteComment(@PathVariable final int mno, @PathVariable final int cno){
        return guestbookService.deleteComment(cno);
    }
}
