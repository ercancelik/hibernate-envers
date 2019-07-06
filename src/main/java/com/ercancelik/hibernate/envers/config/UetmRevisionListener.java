package com.ercancelik.hibernate.envers.config;

import com.ercancelik.hibernate.envers.domain.UetmRevInfo;
import org.hibernate.envers.RevisionListener;

public class UetmRevisionListener implements RevisionListener {

    public final static String USERNAME = "ERCAN";

    @Override
    public void newRevision(Object revisionEntity) {
        UetmRevInfo exampleRevEntity = (UetmRevInfo) revisionEntity;
        //should be retrieved from spring security
        exampleRevEntity.setUsername(USERNAME);
    }
}