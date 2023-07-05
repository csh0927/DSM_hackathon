package com.example.dsm_hackathon.domain.user.domain;

import com.example.dsm_hackathon.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseIdEntity {

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 30)
    private String email;

    @NotNull
    private String password;

    @NotNull
    private Date birth;

    @Column(nullable = false, length = 20)
    private String inSchool;

    @Column(nullable = false, length = 30)
    private String schoolName;

    private String originalFileName;

    private String storedFileName;

    private Long fileSize;

    @Builder
    public User(String name, String email, String password, Date birth, String inSchool, String schoolName,
                String originalFileName, String storedFileName, Long fileSize) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.inSchool = inSchool;
        this.schoolName = schoolName;
        this.originalFileName = originalFileName;
        this.storedFileName = storedFileName;
        this.fileSize = fileSize;
    }
}
