package com.example.dsm_hackathon.global.entity;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseIdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
