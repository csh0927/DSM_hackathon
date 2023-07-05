package com.example.dsm_hackathon.domain.post.controller;

import com.example.dsm_hackathon.domain.post.domain.Post;
import com.example.dsm_hackathon.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/Details")
    public Post mainPage(@RequestParam() Long id){
        return postService.postDetails(id);
    }
}
