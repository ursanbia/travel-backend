package ro.iteahome.travelbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.iteahome.travelbackend.entity.Privilege;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

    Optional<Privilege> findByName(String name);
}
