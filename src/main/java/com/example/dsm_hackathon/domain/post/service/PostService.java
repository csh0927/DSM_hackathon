package com.example.dsm_hackathon.domain.post.service;

import com.example.dsm_hackathon.domain.post.domain.Post;
import com.example.dsm_hackathon.domain.post.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Post postDetails(Long id){
        return postRepository.findAllById(id);
    }
}
