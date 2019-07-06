package com.ercancelik.hibernate.envers.repository;

import com.ercancelik.hibernate.envers.domain.UserRole;
import com.ercancelik.hibernate.envers.domain.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}
