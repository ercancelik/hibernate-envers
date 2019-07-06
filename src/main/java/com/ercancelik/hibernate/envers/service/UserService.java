package com.ercancelik.hibernate.envers.service;

import com.ercancelik.hibernate.envers.domain.Role;
import com.ercancelik.hibernate.envers.domain.User;
import com.ercancelik.hibernate.envers.repository.RoleRepository;
import com.ercancelik.hibernate.envers.repository.UserRepository;
import com.ercancelik.hibernate.envers.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    public User addUser(User user) {

        return this.userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user) {
        Optional<User> temp = userRepository.findById(user.getId());
        if (temp.isPresent()) {
            user.getUserRoles().stream().forEach(userRole -> {
                Optional<User> u = userRepository.findById(userRole.getUser().getId());
                Optional<Role> r = roleRepository.findById(userRole.getRole().getId());
                if (u.isPresent() && r.isPresent()) {
                    userRole.setRole(r.get());
                    userRole.setUser(u.get());
                }
                userRoleRepository.save(userRole);
            });
            temp.get().setUserRoles(user.getUserRoles());
        }

        return temp.get();
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public void deleteUser(User user) {
        Optional<User> temp = this.userRepository.findById(user.getId());
        if (temp.isPresent()) {
            this.userRepository.delete(temp.get());
        }
    }
}
