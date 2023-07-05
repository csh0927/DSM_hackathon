package com.example.dsm_hackathon.domain.image;

import com.example.dsm_hackathon.domain.user.domain.User;
import com.example.dsm_hackathon.domain.user.domain.UserRepository;
import com.example.dsm_hackathon.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ImageHandler {

    private final UserRepository userRepository;

    public List<User> parseFileInfo(Long id, List<MultipartFile> multipartFiles) throws Exception {
        List<User> fileList = new ArrayList<>();

       if(multipartFiles.isEmpty()){
            return fileList;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());

        if(multipartFiles.isEmpty()){
            return fileList;
        }

        String absolutePath = new File("").getAbsolutePath() + "\\";

        String path = "/src/main/resources/static/images/" + current_date;
        File file = new File(path);

        if(file.exists()) {
            file.mkdirs();
        }

        for (MultipartFile multipartFile : multipartFiles) {
            if(!multipartFile.isEmpty()) {
                String contentType = multipartFile.getContentType();
                String originalFileExtension;

                if (ObjectUtils.isEmpty(contentType)) {
                    break;
                } else {
                    if (contentType.contains("image/jpeg")) {
                        originalFileExtension = ".jpg";
                    } else if (contentType.contains("image/png")) {
                        originalFileExtension = ".png";
                    } else if (contentType.contains("image/gif")) {
                        originalFileExtension = ".gif";
                    }
                    else {
                        break;
                    }
                }
                String newFileName = System.nanoTime() + originalFileExtension;

                User user = userRepository.findById(id).orElseThrow(() -> UserNotFoundException.EXCEPTION);
                user.uploadImages(multipartFile.getOriginalFilename(),  "images/" + current_date + "/" + newFileName, multipartFile.getSize());
                userRepository.save(user);

                file = new File((absolutePath + path + "/" + newFileName));
                multipartFile.transferTo(file);

            }
        }

        return fileList;
    }
}