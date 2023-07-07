package com.example.dsm_hackathon.domain.post.controller;

import com.example.dsm_hackathon.domain.post.domain.Post;
import com.example.dsm_hackathon.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/main")
    public List<Post> mainPage() {
        return postService.mainPage();
    }

    @GetMapping("/details")
    public Post postDetails(@RequestParam() Long id){
        return postService.postDetails(id);
    }


    @GetMapping("/find")
    public List<Post> findPost(@RequestParam() String keyword){
        return postService.findPost(keyword);
    }
}