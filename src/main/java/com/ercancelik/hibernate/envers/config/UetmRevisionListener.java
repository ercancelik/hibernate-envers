package com.ercancelik.hibernate.envers.config;

import com.ercancelik.hibernate.envers.domain.CustomRevisionEntity;
import org.hibernate.envers.RevisionListener;

public class UetmRevisionListener implements RevisionListener {

    public final static String USERNAME = "ERCAN";

    @Override
    public void newRevision(Object revisionEntity) {
        CustomRevisionEntity exampleRevEntity = (CustomRevisionEntity) revisionEntity;
        //should be retrieved from spring security
        exampleRevEntity.setUsername(USERNAME);
    }
}