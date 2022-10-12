package com.sparta.submitHomwork.controller;

import com.sparta.submitHomwork.domain.Comment;
import com.sparta.submitHomwork.dto.CommentRequestDto;
import com.sparta.submitHomwork.service.CommentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PutMapping("/api/auth/comment")
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    @GetMapping("/api/comment/{id}")
    public List<Comment> getAllComment() {
        return commentService.getAllComment();
    }

    @PutMapping("/api/auth/comment/{id}")
    public Long updateComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long id){
        commentService.update(requestDto,id);
        return id;
    }

    @DeleteMapping("/api/auth/comment/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentService.delete(id);
        return id;
    }


    /*//모든 글 읽어 오기
    @GetMapping("/dev/comment")
    public List<Comment> getAllpost(){return commentService.getAllpost();}

    //댓글 쓰기
    @PostMapping("/dev/comment/{id}")
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    //댓글 수정
    @PutMapping("/dev/comment/{id}")
    public Optional<Comment> updateComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long id){
        return commentService.updateComment(requestDto, id);}


    //댓글 삭제
    @DeleteMapping("/dev/comment/{id}")
    public void deleteComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long id) {
        commentService.deleteComment(requestDto,id);
    }*/
}
