package com.ercancelik.hibernate.envers.repository;

import com.ercancelik.hibernate.envers.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
