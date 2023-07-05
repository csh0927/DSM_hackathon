package com.example.dsm_hackathon.domain.post.service;

import com.example.dsm_hackathon.domain.post.domain.Post;
import com.example.dsm_hackathon.domain.post.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<Post> mainPage(){
        return postRepository.findAll();
    }

    public Post postDetails(Long id){
        return postRepository.findAllById(id);
    }
}
