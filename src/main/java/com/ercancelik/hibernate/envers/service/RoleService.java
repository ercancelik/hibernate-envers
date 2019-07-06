package com.ercancelik.hibernate.envers.service;

import com.ercancelik.hibernate.envers.domain.Role;
import com.ercancelik.hibernate.envers.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Transactional
    public Role updateRole(Role role) {
        Optional<Role> temp = roleRepository.findById(role.getId());
        if (temp.isPresent()) {
            temp.get().setName(role.getName());
            return temp.get();
        }
        return null;
    }

    public List<Role> getAll() {
        return this.roleRepository.findAll();
    }

    public void deleteRole(Role role) {
        Optional<Role> temp = roleRepository.findById(role.getId());
        if (temp.isPresent()) {
            this.roleRepository.delete(temp.get());
        }
    }
}
