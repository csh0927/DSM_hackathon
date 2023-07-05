package com.example.dsm_hackathon.domain.user.service;

import com.example.dsm_hackathon.domain.image.ImageHandler;
import com.example.dsm_hackathon.domain.user.domain.User;
import com.example.dsm_hackathon.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final UserRepository userRepository;

    private final ImageHandler imageHandler;

    public void add(Long id, List<MultipartFile> files) throws Exception {
        imageHandler.parseFileInfo(id, files);

    }

    public Optional<User> findUser(Long id){
        return userRepository.findById(id);
    }
}
