package com.ercancelik.hibernate.envers.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Audited
@Entity
@Table(name = "user")
public class User extends AuditEntity {
    private String sso;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user")
    private Set<UserRole> userRoles = new HashSet<>(0);
}
