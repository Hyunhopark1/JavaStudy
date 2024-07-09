package com.maven.springboot.rentcar.vehicleType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleTypeJpaRepository extends JpaRepository<VehicleTypeEntity, Long> {

    Optional<VehicleTypeEntity> findByName(String name);
    List<VehicleTypeEntity> findAllByNameContains(String name);
}
