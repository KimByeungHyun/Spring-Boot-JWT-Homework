package com.sparta.submitHomwork.domain;
import com.sparta.submitHomwork.dto.CommentRequestDto;
import com.sparta.submitHomwork.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String postId;

    @Column(nullable = true)
    private String content;

    public Comment(String postId, String content) {
        this.postId = postId;
        this.content = content;
    }
    public Comment(CommentRequestDto requestDto) {
        this.postId = requestDto.getPostId();
        this.content = requestDto.getContent();
    }

    public void update(CommentRequestDto requestDto) {
        this.postId = requestDto.getPostId();
        this.content = requestDto.getContent();
    }


}
