package com.example.dsm_hackathon.domain.post.domain;


import com.example.dsm_hackathon.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private Integer amount;

    @Column(nullable = false, length = 10)
    private String schoolType;

    @Column(nullable = false, length = 10)
    private String field;

    public Post(String title, String foundation, Date startPeriod, Date endPeriod, Integer personnel,
                Integer amount, String schoolType, String field) {
        this.title = title;
        this.foundation = foundation;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.personnel = personnel;
        this.amount = amount;
        this.schoolType = schoolType;
        this.field = field;
    }
}
