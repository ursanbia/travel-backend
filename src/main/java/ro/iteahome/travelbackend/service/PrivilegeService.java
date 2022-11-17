package ro.iteahome.travelbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ro.iteahome.travelbackend.entity.Privilege;
import ro.iteahome.travelbackend.repository.PrivilegeRepository;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @PreAuthorize("hasAuthority('CAN_WRITE')")
    public Privilege save(Privilege privilege) {
        return privilegeRepository.save(privilege);
    }

    @PreAuthorize("hasAuthority('CAN_READ')")
    public Iterable<Privilege> findAll() {
        return privilegeRepository.findAll();
    }

}
