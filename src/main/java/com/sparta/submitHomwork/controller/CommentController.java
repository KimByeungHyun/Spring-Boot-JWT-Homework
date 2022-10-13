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
}
