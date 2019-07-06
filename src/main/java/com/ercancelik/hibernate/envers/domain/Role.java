package com.ercancelik.hibernate.envers.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Audited
@Entity
@Table(name = "role")
public class Role extends AuditEntity {
    @Column(name = "name")
    private String name;

    @NotAudited
    private String dontAudit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.role")
    private Set<UserRole> userRoles = new HashSet<>(0);
}
