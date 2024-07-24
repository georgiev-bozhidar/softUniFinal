package org.georgievbozhidar.softunifinal2.repository;

import org.georgievbozhidar.softunifinal2.entity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
