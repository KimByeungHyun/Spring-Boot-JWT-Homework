package com.sparta.submitHomwork.service;

import com.sparta.submitHomwork.domain.Comment;
import com.sparta.submitHomwork.dto.CommentRequestDto;
import com.sparta.submitHomwork.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComment() {
        return commentRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public Long update(CommentRequestDto reaquestDto, Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id 없습니다.")
        );
        comment.update(reaquestDto);
        return comment.getId();
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
