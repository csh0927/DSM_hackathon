package com.example.dsm_hackathon.domain.post.service;

import com.example.dsm_hackathon.domain.post.domain.Post;
import com.example.dsm_hackathon.domain.post.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Post> findPost(String keyword){
        List<Post> postList = postRepository.findAll();

        List<Post> allPost = postList
                .stream()
                .filter(post -> post.getTitle().contains(keyword))
                .collect(Collectors.toList()
                );

        return allPost;
    }
}
