package com.example.dsm_hackathon.domain.post.domain;


import com.example.dsm_hackathon.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Post extends BaseIdEntity {

    @Column(nullable = false, length = 45)
    private String title;

    @Column(nullable = false, length = 40)
    private String foundation;

    @NotNull
    private Date startPeriod;

    @NotNull
    private Date endPeriod;

    private Integer personnel;

    @NotNull
    private Long amount;

    @Column(nullable = false, length = 10)
    private String schoolType;

    @Column(nullable = false, length = 10)
    private String field;

    @Length(max = 45)
    private String region;

    @Column(nullable = false, length = 100)
    private String mean;

    @Column(nullable = false, length = 100)
    private String qualification;

    @Column(nullable = false, length = 100)
    private String selection;

    @Column(nullable = false, length = 100)
    private String procedure;

    @Column(nullable = false, length = 100)
    private String url;

    @Builder

    public Post(String title, String foundation, Date startPeriod, Date endPeriod, Integer personnel, Long amount,
                String schoolType, String field, String region , String mean, String qualification, String selection, String procedure,
                String url) {
        this.title = title;
        this.foundation = foundation;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.personnel = personnel;
        this.amount = amount;
        this.schoolType = schoolType;
        this.field = field;
        this.region = region;
        this.mean = mean;
        this.qualification = qualification;
        this.selection = selection;
        this.procedure = procedure;
        this.url = url;
    }
}
