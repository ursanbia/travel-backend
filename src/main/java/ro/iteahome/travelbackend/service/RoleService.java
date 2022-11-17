package ro.iteahome.travelbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ro.iteahome.travelbackend.entity.Role;
import ro.iteahome.travelbackend.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @PreAuthorize("hasAuthority('CAN_WRITE')")
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @PreAuthorize("hasAuthority('CAN_READ')")
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }
}
