package com.ercancelik.hibernate.envers.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class UserRoleId implements Serializable {
    @ManyToOne
    private User user;
    @ManyToOne
    private Role role;
}
