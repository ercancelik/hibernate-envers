package com.ercancelik.hibernate.envers.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@Getter
@Setter
@Audited
@Entity
@Table(name = "user_roles")
@AssociationOverrides({
        @AssociationOverride(name = "pk.user", joinColumns = @JoinColumn(name = "USER_ID")),
        @AssociationOverride(name = "pk.role", joinColumns = @JoinColumn(name = "ROLE_ID"))
})
public class UserRole{
    @EmbeddedId
    private UserRoleId pk = new UserRoleId();

    @Column(name = "created_date", updatable = false, nullable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;

    public User getUser() {
        return getPk().getUser();
    }

    public void setUser(User user) {
        getPk().setUser(user);
    }

    public Role getRole() {
        return getPk().getRole();
    }

    public void setRole(Role role) {
        getPk().setRole(role);
    }
}
