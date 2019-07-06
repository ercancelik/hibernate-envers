package com.ercancelik.hibernate.envers.repository;

import com.ercancelik.hibernate.envers.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
