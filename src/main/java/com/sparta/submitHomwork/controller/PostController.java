package com.sparta.submitHomwork.controller;

import com.sparta.submitHomwork.domain.Post;
import com.sparta.submitHomwork.dto.PostRequestDto;
import com.sparta.submitHomwork.repository.PostRepository;
import com.sparta.submitHomwork.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;
//    @Autowired
//    public PostController(PostService postService) {this.postService = postService;}

    //모든 글 읽어 오기
    @GetMapping("/api/post")
    public List<Post> getAllpost(){
        return postService.getAllpost();
    }

    // 게시글 작성
    @PostMapping("")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    // 게시글 상세 조회
    @GetMapping("api/post/{id}")
    public Optional<Post> getPost(@PathVariable Long id){
        return postRepository.findById(id);
    }

    //글 수정
    @PutMapping("/api/auth/post/{id}")
    public Optional<Post> updatePost(@RequestBody PostRequestDto requestDto, @PathVariable Long id){
        return postService.updatePost(requestDto, id);}

    //글 삭제
    @DeleteMapping("/api/auth/post/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

}
