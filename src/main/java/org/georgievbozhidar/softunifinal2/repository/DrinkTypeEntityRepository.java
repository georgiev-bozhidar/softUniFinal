package org.georgievbozhidar.softunifinal2.repository;

import org.georgievbozhidar.softunifinal2.entity.enums.DrinkType;
import org.georgievbozhidar.softunifinal2.entity.model.DrinkTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkTypeEntityRepository extends JpaRepository<DrinkTypeEntity, Long> {
}
