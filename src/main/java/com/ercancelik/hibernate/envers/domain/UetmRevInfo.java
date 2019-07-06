package com.ercancelik.hibernate.envers.domain;

import com.ercancelik.hibernate.envers.config.UetmRevisionListener;
import lombok.Data;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.Entity;

@Data
@Entity
@RevisionEntity(UetmRevisionListener.class)
public class UetmRevInfo extends DefaultRevisionEntity {
    private String username;
}