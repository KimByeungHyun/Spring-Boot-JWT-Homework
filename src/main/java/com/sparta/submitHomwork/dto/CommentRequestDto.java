package com.sparta.submitHomwork.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private String postId;
    private String content;

}
