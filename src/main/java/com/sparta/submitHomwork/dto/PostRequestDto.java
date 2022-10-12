package com.sparta.submitHomwork.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRequestDto {
    private String username;
    private String title;
    private String contents;
}