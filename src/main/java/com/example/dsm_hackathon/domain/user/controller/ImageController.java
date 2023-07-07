
package com.example.dsm_hackathon.domain.user.controller;


import com.example.dsm_hackathon.domain.user.domain.User;
import com.example.dsm_hackathon.domain.user.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
public class ImageController {

    private final ImageService imageService;

    @PatchMapping("users/image/{id}")
    public ResponseEntity<?> addImages(@Validated @RequestParam("files") List<MultipartFile> files, @PathVariable @Valid Long id) throws Exception {
        imageService.add(id, files);

        return ResponseEntity.ok().build();
    }

    @GetMapping("users/show/{id}")
    public String getUser(@PathVariable @Valid Long id){
        User user = imageService.findUser(id).orElseThrow(RuntimeException::new);
        String imgPath = user.getStoredFileName();
        log.info(imgPath);
        return "<img src=" + imgPath + ">";
    }
}
