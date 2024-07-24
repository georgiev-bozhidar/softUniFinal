package org.georgievbozhidar.softunifinal2.repository;

import org.georgievbozhidar.softunifinal2.entity.model.LocationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationTypeEntityRepository extends JpaRepository<LocationTypeEntity, Long> {

}
